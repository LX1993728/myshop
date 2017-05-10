package myshop.ssh.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 发送邮件的工具类
 * 
 * @author liuxun
 *
 */
public class MailUtils {
	public static void sendMail(String to, String code) throws Exception {
		Properties props = new Properties();
		// 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.126.com");
        // 发件人的账号
        props.put("mail.user", "liuxun1993728");
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", "liuxun1993728");

		// 1.Session对象.连接(与邮箱服务器连接)
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("liuxun1993728", "liuxun1993728");
			}
		});

		// 2.构建邮件信息
		Message message = new MimeMessage(session);
		// 发件人
		message.setFrom(new InternetAddress("liuxun1993728@126.com"));
		// 收件人
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// 设置标题
		message.setSubject("来自京亿商城的激活邮件");
		// 设置正文
		message.setContent(
				"<h1>来自京亿商城的官网激活邮件<h1><h3><a href='http://192.168.1.25:8080/myshop/user_active.action?code=" + code
						+ "'>http://192.168.1.25:8080/myshop/user_active.action?code=" + code + "</a></h3>",
				"text/html;charset=UTF-8");
	
		// 3.发送对象
		Transport.send(message);
	}
}
