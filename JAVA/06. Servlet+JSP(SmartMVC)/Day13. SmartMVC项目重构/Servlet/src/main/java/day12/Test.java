package day12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Retention 用于声明注解 @Test 的保留范围
@Retention(RetentionPolicy.RUNTIME)
//Target 用于声明 注解的标注位置，当设置为METHOD以后
// 注解 @Test 就只能在方法上标注使用 
@Target(ElementType.METHOD) 
public @interface Test {

}
