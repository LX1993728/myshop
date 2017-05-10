package myshop.ssh.utils;

import java.util.UUID;

/**
 * 生成激活码
 * 
 * @author liuxun
 *
 */
public class UUIDUtils {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
