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
 * ��ʼ�� URL �� ������ ��ӳ��� 
 */
public class ContextConfigListener implements ServletContextListener {
	
	/**
	 * ��ȡ beans.xml �����ļ���
	 * ���������ļ��ж���Ŀ�������
	 * �����������urlӳ�䵽��Ӧ�Ŀ���������
	 * @param xml
	 * @return ����url������������ӳ���ϵ��
	 *         HandlerMapping����
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
			//��beanԪ���ϻ�ȡclass���Ե�ֵ��Ϊ����
			String className=e.attributeValue("class");
			System.out.println(className);
			//����������ʼ�� HandlerMapping �е�map
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
	    	System.out.println("��ʼ����handlerMapping"); 
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		throw new RuntimeException(ex);
    	}
    }
    public void contextDestroyed(ServletContextEvent arg0)  { 
    }

}
