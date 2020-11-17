package emp;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.EmpDao;
import entity.Emp;
import mvc.RequestMapping;

public class EmpController {
	
	@RequestMapping("/emp/list.do")
	public String list(HttpServletRequest request) {
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		Map<Integer, String> names=new HashMap<>();
		for (Emp emp : list) {
			names.put(emp.getEmpno(), emp.getEname());
		}
		//利用request对象将数据共享到JSP页面
		request.setAttribute("list", list);
		request.setAttribute("names", names);
		//转发的员工列表页面
		return "list-emp2";
	}
	
	@RequestMapping("/emp/add.do")
	public String add(HttpServletRequest request) {
		EmpDao dao = new EmpDao();
		List<Emp> mgrs = dao.findMgrs();
		request.setAttribute("mgrs", mgrs);
		return "add-emp";
	}
	@RequestMapping("/emp/save.do")
	public String save(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
			String ename=request.getParameter("ename");
			String mgrId=request.getParameter("mgr");
			String date =request.getParameter("hiredate");
			String deptId=request.getParameter("deptno");
			String salarys=request.getParameter("salary");
			String comms = request.getParameter("comm");

			//数据类型转换: 将字符串转换为目标数据类型
			SimpleDateFormat fmt=
				new SimpleDateFormat("yyyy-MM-dd");
			int mgr = Integer.parseInt(mgrId);
			Date hiredate = new Date(
					fmt.parse(date).getTime());
			int deptno = Integer.parseInt(deptId);
			double salary = Double.parseDouble(salarys);
			double comm = Double.parseDouble(comms);
			//保存到数据库
			Emp emp = new Emp(0, ename, mgr, hiredate, deptno, salary, comm);
			EmpDao dao = new EmpDao();
			int n = dao.save(emp);
			if(n==1) {
				//设置绝对重定向路径
				String url= request.getContextPath()+"/emp/list.do";
				return "redirect:"+url;
			}else {
				//失败
				request.setAttribute("message", "添加失败!");
				return "message";
			}
		}catch(Exception e) {
			e.printStackTrace(); 
			throw new RuntimeException(e);
		}
	}
	@RequestMapping("/emp/delete.do")
	public String delete(HttpServletRequest request) {
		String no = request.getParameter("empno");
		//请自行打桩测试接收到的参数是否有效
		int empno = Integer.parseInt(no);
		//调用EmpDao删除数据
		EmpDao dao = new EmpDao();
		int n = dao.delete(empno);
		if(n==1) {
			//重定向到 员工列表页面, 显示结果
			String path=request.getContextPath()+
					"/emp/list.do";
			return "redirect:"+path;
		} else {
			//转发到message.jsp显示错误消息
			request.setAttribute("message", "删除失败");
			return "message";
		}

	}
	@RequestMapping("/emp/edit.do")
	public String edit(HttpServletRequest request) {
		String no = request.getParameter("empno");
		int empno = Integer.parseInt(no);
		EmpDao dao = new EmpDao();
		Emp emp = dao.findByEmpno(empno);
		
		List<Emp> mgrs = dao.findMgrs();
		
		request.setAttribute("mgrs", mgrs);
		request.setAttribute("emp", emp);
		
		return "edit-emp";
	}
	@RequestMapping("/emp/update.do")
	public String update(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
			String no = request.getParameter("empno");
			String ename=request.getParameter("ename");
			String mgrno=request.getParameter("mgr");
			String hire=request.getParameter("hiredate");
			String dept=request.getParameter("deptno");
			String sly =request.getParameter("salary");
			String com =request.getParameter("comm");
			int empno = Integer.parseInt(no);
			int mgr = Integer.parseInt(mgrno);
			//java.sql.Date 提供了将字符串转换为日期的方法
			Date hiredate = Date.valueOf(hire);
			int deptno = Integer.parseInt(dept);
			double salary = Double.parseDouble(sly);
			double comm = Double.parseDouble(com);
			
			Emp emp = new Emp(empno, ename, mgr, 
				hiredate, deptno, salary, comm);
			EmpDao dao = new EmpDao();
			//更新数据
			int n = dao.updateEmp(emp);
			if(n==1) {
				String path=request.getContextPath()+
						"/emp/list.do";
				return "redirect:"+path; 
			} else {
				request.setAttribute("message", 
						"更新失败！");
				return "message";
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e); 
		}
	}
	
}








