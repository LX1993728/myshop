package myshop.ssh.order;

import myshop.ssh.product.Product;

/**
 * 订单项实体
 * 
 * @author liuxun
 *
 */
public class OrderItem {
	private Integer itemid;
	private Integer count;
	private Double subtotal;
	// 订单项包含的商品信息
	private Product product;
	// 订单项所属的订单
	private Order order;

	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
