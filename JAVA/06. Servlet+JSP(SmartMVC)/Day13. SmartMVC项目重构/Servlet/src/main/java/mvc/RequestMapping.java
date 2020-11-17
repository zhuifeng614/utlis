package mvc;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
/** 
 * ��ע�ڿ�����������
 * ��;��������url��ַӳ�䵽��ǰ�ķ�����
 * Ӣ�ķ��룺 Request ����  Mapping ӳ��
 */
public @interface RequestMapping {
	//Ϊע�ⶨ�����
	public String value();
}
