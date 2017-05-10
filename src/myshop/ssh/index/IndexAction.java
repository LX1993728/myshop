package myshop.ssh.index;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import myshop.ssh.category.Category;
import myshop.ssh.category.CategoryService;
import myshop.ssh.product.Product;
import myshop.ssh.product.ProductService;

/**
 * 首页访问的Action
 * 
 * @author liuxun
 *
 */
public class IndexAction extends ActionSupport {
	// 注入一级分类的Service
	private CategoryService categoryService;
	// 注入商品的Service
	private ProductService productService;
	// 热门商品的集合
	private List<Product> hotList;
	// 最新商品的集合
	private List<Product> newList;

	public List<Product> getHotList() {
		return hotList;
	}

	public List<Product> getNewList() {
		return newList;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// 执行首页访问的方法
	public String execute() throws Exception {
		// 查询所有的一级分类
		List<Category> categoryList = categoryService.findAll();
		// 存入Session中
		ActionContext.getContext().getSession().put("categoryList", categoryList);
		// 查询热门商品
		hotList = productService.findHot();
		// 查询最新商品
		newList = productService.findNew();
		return "indexSuccess";
	}
}
