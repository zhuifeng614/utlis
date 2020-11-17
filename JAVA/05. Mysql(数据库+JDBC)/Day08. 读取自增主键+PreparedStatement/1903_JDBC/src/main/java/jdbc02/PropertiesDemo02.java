package jdbc02;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo02 {

	public static void main(String[] args)
		throws Exception {
		/**
		 * 利用Properties API 读取配置文件db.properties信息
		 */
		//利用当前的classLoader 加载resource中的资源
		String file="db.properties"; 
		//固定写法: 
		// 类名.class.getClassLoader().getResourceAsStream()
		InputStream in=PropertiesDemo02.class
				.getClassLoader()
				.getResourceAsStream(file);
		Properties cfg = new Properties();
		//将资源中信息读取到 Properties 对象中
		cfg.load(in); 
		in.close();
		//检查读取结果
		System.out.println(cfg);  
		//获取一个参数
		System.out.println(cfg.getProperty("url"));
		System.out.println(cfg.get("url")); 
	}

}



