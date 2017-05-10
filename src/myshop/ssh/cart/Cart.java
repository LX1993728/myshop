package myshop.ssh.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 购物车对象
 * 
 * @author liuxun
 *
 */
public class Cart {
	// 购物车存放多个购物对象
	// Map集合用商品的ID作为Map的key，购物项作为Map的value
	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();

	// 提供一个获得map的value的集合
	// 相当于有一个属性：cartItems
	public Collection<CartItem> getCartItems() {
		return map.values();
	}

	// 总计
	private Double total = 0d;
    
	public Double getTotal() {
		return total;
	}

	// 提供三个方法
	// 将购物项添加到购物车
	public void addCart(CartItem cartItem) {
		// 获得购物项的标识ID
		Integer pid = cartItem.getProduct().getPid();
		if (map.containsKey(pid)) {
			// 购物车中已经存在此购物项
			// 获取购物车中已经存在的购物项的信息
			CartItem _cartItem = map.get(pid);
			_cartItem.setCount(_cartItem.getCount() + cartItem.getCount());
		} else {
			// 购物车中不存在该购物项
			map.put(pid, cartItem);
		}
		// 总计
		total += cartItem.getSubtotal();
	}

	// 将购物项从购物车移除
	public void removeCart(Integer pid) {
		// 将购物项从Map中移除
		CartItem cartItem = map.remove(pid);
		// 设置总计钱数
		total -= cartItem.getSubtotal();
	}

	// 清空购物车
	public void clearCart() {
		// 清空Map
		map.clear();
		// 总计置为0
		total = 0d;
	}
}
