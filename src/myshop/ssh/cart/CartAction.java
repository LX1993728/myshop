package myshop.ssh.cart;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import myshop.ssh.product.Product;
import myshop.ssh.product.ProductService;

// 接收购物模块的Action类
public class CartAction extends ActionSupport {
	// 接收pid
	private Integer pid;
	// 接收count
	private Integer count;
	// 注入ProductService
	private ProductService productService;

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * 从Session范围获取购物车的代码
	 */
	public Cart getCart(HttpServletRequest request) {
		// 从session范围获得Cart对象
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		// 判断
		if (cart == null) {
			// 创建购物车对象
			cart = new Cart();
			// 将购物车放入到Session范围
			request.getSession().setAttribute("cart", cart);
		}
		return cart;
	}

	/**
	 * 添加到购物车的方法
	 */
	public String addCart() {
		// 查询商品信息
		Product product = productService.findByPid(pid);
		// 创建一个购物车对象
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		cartItem.setProduct(product);
		// 获取购物车，需要依赖request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		Cart cart = getCart(request);
		cart.addCart(cartItem);
		return "addCartSuccess";
	}

	/**
	 * 清空购物车
	 */
	public String clearCart() {
		// 获取Cart对象
		HttpServletRequest request = ServletActionContext.getRequest();
		Cart cart = getCart(request);
		cart.clearCart();

		return "clearCartScuccess";
	}

	/**
	 * 移除购物车
	 */
	public String removeCart() {
		// 获取Cart对象
		HttpServletRequest request = ServletActionContext.getRequest();
		Cart cart = getCart(request);
		cart.removeCart(pid);

		return "removeCartSuccess";
	}

	/**
	 * 我的购物车
	 */
	public String myCart() {
		return "myCartSuccess";
	}

}
