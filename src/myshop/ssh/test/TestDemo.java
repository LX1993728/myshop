package myshop.ssh.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myshop.ssh.product.Product;
import myshop.ssh.product.ProductDao;
import myshop.ssh.product.ProductService;
import myshop.ssh.utils.PageBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDemo {
	@Autowired
	@Qualifier("productDao")
	private ProductDao productDao;

	@Resource(name = "productService")
	private ProductService productService;

	@Test
	public void demo1() {
		List<Product> list = productDao.findHot();
		System.out.println(list.size());
	}

	@Test
	public void demo2() {
		PageBean<Product> pageBean = productService.findByPage(1, 1);
		System.out.println(pageBean.getTotalPage());
	}
}
