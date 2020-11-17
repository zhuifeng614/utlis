package jdbc02;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo02 {

	public static void main(String[] args)
		throws Exception {
		/**
		 * ����Properties API ��ȡ�����ļ�db.properties��Ϣ
		 */
		//���õ�ǰ��classLoader ����resource�е���Դ
		String file="db.properties"; 
		//�̶�д��: 
		// ����.class.getClassLoader().getResourceAsStream()
		InputStream in=PropertiesDemo02.class
				.getClassLoader()
				.getResourceAsStream(file);
		Properties cfg = new Properties();
		//����Դ����Ϣ��ȡ�� Properties ������
		cfg.load(in); 
		in.close();
		//����ȡ���
		System.out.println(cfg);  
		//��ȡһ������
		System.out.println(cfg.getProperty("url"));
		System.out.println(cfg.get("url")); 
	}

}



