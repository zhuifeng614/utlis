package day13;

import java.lang.reflect.Method;

import mvc.RequestMapping;

public class Demo01 {

	public static void main(String[] args) 
		throws Exception{
		/*
		 * ���� BizController���@RequestMappingע��
		 */
		String className="mvc.BizController";
		//��̬������
		Class cls = Class.forName(className);
		//��̬�ҵ������ȫ������
		Method[] methods=cls.getDeclaredMethods();
		//����ȫ�����������ұ�ע�� @RequestMapping ע��
		for(Method method:methods) {
			//����RequestMapping.class�����ҵ��Ķ���
			//�� RequestMapping ���͵Ķ��󣬰���value����
			RequestMapping ann=method.getAnnotation(
					RequestMapping.class);
			if(ann!=null) {
				//����ע������ϵ� value��������ȡ����ע��ֵ
				String val = ann.value();
				System.out.println(val); 
				System.out.println(method);
			}
		}
		
	}

}




