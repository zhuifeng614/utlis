package day12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Retention ��������ע�� @Test �ı�����Χ
@Retention(RetentionPolicy.RUNTIME)
//Target �������� ע��ı�עλ�ã�������ΪMETHOD�Ժ�
// ע�� @Test ��ֻ���ڷ����ϱ�עʹ�� 
@Target(ElementType.METHOD) 
public @interface Test {

}
