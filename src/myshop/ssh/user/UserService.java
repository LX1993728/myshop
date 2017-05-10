package myshop.ssh.user;

import myshop.ssh.utils.MailUtils;
import myshop.ssh.utils.UUIDUtils;

/**
 * 用户模块:业务层代码
 * 
 * @author liuxun
 *
 */
public class UserService {
	// 注入Dao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 业务层注册用户的代码
	 * 
	 * @param user
	 */
	public void regist(User user) {
		// 保存用户
		user.setState(0); // 0:未激活 1:已经激活
		String code = UUIDUtils.getUUID() + UUIDUtils.getUUID(); // 生成激活码
		user.setCode(code);
		userDao.save(user);
		// 发送邮件
		try {
			MailUtils.sendMail(user.getEmail(), user.getCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 业务层根据激活码查询用户的方法
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	// 业务层修改用户的方法
	public void update(User existUser) {
		userDao.update(existUser);
	}

	// 前台:登录功能
	public User login(User user) {
		return userDao.login(user);
	}

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

}
