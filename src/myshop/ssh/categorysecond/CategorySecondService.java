package myshop.ssh.categorysecond;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import myshop.ssh.category.Category;
import myshop.ssh.utils.PageBean;

@Transactional
public class CategorySecondService {
	// 注入DAO
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	// 业务层带有分夜查询的二级分类
	public PageBean<CategorySecond> findByPage(Integer page) {
		// 封装PageBean
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		// 封装页数
		pageBean.setPage(page);
		// 每页显示的记录数
		int limit = 10;
		pageBean.setLimit(limit);
		// 总记录数
		Integer totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 总页数
		Integer totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据
		Integer begin = (page - 1) * limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// 业务层保存二级分类
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}


}
