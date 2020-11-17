package mvc;

import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 初始化 URL 到 控制器 的映射表 
 */
public class ContextConfigListener implements ServletContextListener {
	
	/**
	 * 读取 beans.xml 配置文件，
	 * 解析配置文件中定义的控制器类
	 * 将控制器类的url映射到对应的控制器方法
	 * @param xml
	 * @return 包含url到控制器方法映射关系的
	 *         HandlerMapping对象
	 */
	public HandlerMapping loadControlers(String xml)
		throws Exception {
		SAXReader reader = new SAXReader();
		InputStream in = ContextConfigListener.class
			.getClassLoader().getResourceAsStream(xml);
		System.out.println(in); 
		Document doc = reader.read(in);
		in.close();
		Element root = doc.getRootElement();//beans
		List<Element> list=root.elements("bean"); 
		HandlerMapping mapping = new HandlerMapping();
		for(Element e:list) {
			//在bean元素上获取class属性的值作为类名
			String className=e.attributeValue("class");
			System.out.println(className);
			//利用类名初始化 HandlerMapping 中的map
			mapping.init(className);
		}
		return mapping;
	}
	
    public void contextInitialized(
    		ServletContextEvent e)  {
    	try {
	    	ServletContext ctx = e.getServletContext();
	    	//HandlerMapping mapping=new HandlerMapping();
	    	//mapping.init("mvc.BizController"); 
	    	HandlerMapping mapping=loadControlers(
	    			"beans.xml");
	    	
	    	String path = ctx.getContextPath();
	    	ctx.setAttribute("root", path); 
	    	
	    	ctx.setAttribute("handlerMapping", mapping);
	    	System.out.println("初始化了handlerMapping"); 
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		throw new RuntimeException(ex);
    	}
    }
    public void contextDestroyed(ServletContextEvent arg0)  { 
    }

}
