package mvc;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
/** 
 * 标注在控制器方法上
 * 用途：将请求url地址映射到当前的方法上
 * 英文翻译： Request 请求  Mapping 映射
 */
public @interface RequestMapping {
	//为注解定义参数
	public String value();
}
