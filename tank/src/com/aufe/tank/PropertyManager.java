package com.aufe.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * 配置文件管理类
 * @author whitecat
 *
 */
public class PropertyManager {
	
	static Properties props = new Properties();
	
	static {
		try {
			props.load(PropertyManager.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object getKey(String key) {
		
		if (props == null) {
			return null;
		}
		
		return props.get(key);
		
	}
	
//	public static void main(String[] args) {
//		System.out.println(PropertyManager.getKey("initTankCount"));
//	}
	
}
