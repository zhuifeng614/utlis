package demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * ���ô����� 
 */
public class ProxyHandler<E> 
	implements InvocationHandler {
	private List<E> target;//�������Ŀ�����
	public ProxyHandler() {
		target = new ArrayList<E>();
	}
	public ProxyHandler(List<E> target) {
		this.target = target;
	}

	//����ֵ��Ŀ�귽��ִ���Ժ�ķ���ֵ
	public Object invoke(
			Object proxy, //��̬���ɵĴ������
			Method method,//���ڱ����õķ���
			Object[] args)//���÷���ʱ�򴫵ݵ�ʵ�ʲ���
			throws Throwable {
		System.out.println("���ڵ��ã�"+method);
		synchronized (proxy) {
			//��target������ִ��method��Ӧ�ķ���
			return method.invoke(target, args);
			//����     add()         list    e
			//��ִ���� �� list.add(e) 
		}
	}
}


