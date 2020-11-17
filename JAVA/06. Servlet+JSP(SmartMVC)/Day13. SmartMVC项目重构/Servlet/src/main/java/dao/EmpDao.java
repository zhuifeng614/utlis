package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

 

import entity.Emp;
import util.DBUtil;

/**
 * 封装对 Emp 表的数据访问功能 
 */
public class EmpDao {
	/**
	 * 根据ID获取一个员工信息
	 */
	public Emp findByEmpno(int empno) {
		String sql = "select empno, ename, mgr, " + 
				"hiredate, deptno, salary, comm " + 
				"from t_emp where empno=?";
		try(Connection conn = DBUtil.getConnection()){
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, empno);
			ResultSet rs = ps.executeQuery();
			Emp emp=null;
			while(rs.next()) {
				emp = row2Emp(rs); //重用 row2Emp 方法
			}
			return emp; //找到结果返回emp对象，
			//找不到返回null表示"空"结果。
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据ID更新员工信息
	 */
	public int updateEmp(Emp emp) {
		String sql = "update t_emp set ename=?, "
				+ "mgr=?, hiredate=?, deptno=?,"
				+ "salary=?, comm=? "
				+ "where empno=?";
		try(Connection conn = DBUtil.getConnection()){
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, emp.getEname());
			ps.setInt(2, emp.getMgr());
			ps.setDate(3, emp.getHiredate());
			ps.setInt(4, emp.getDeptno());
			ps.setDouble(5, emp.getSalary());
			ps.setDouble(6, emp.getComm());
			ps.setInt(7, emp.getEmpno());
			int n = ps.executeUpdate();
			return n;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获取员工中的全部领导
	 */
	public List<Emp> findMgrs(){
		String sql = "select empno, ename, mgr, "
				+ "hiredate, deptno, salary, comm "
				+ "from t_emp where mgr=0 or mgr=1";
		try(Connection conn=DBUtil.getConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<Emp> list=new ArrayList<>();
			while(rs.next()) {
				//必须是没有编译错误，并且选定的代码块能够抽取为方法！
				Emp emp = row2Emp(rs);
				list.add(emp);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	private Emp row2Emp(ResultSet rs) throws SQLException {
		int empno = rs.getInt("empno");
		String ename = rs.getString("ename");
		int mgr = rs.getInt("mgr");
		Date hiredate=rs.getDate("hiredate");
		int deptno = rs.getInt("deptno");
		double salary = rs.getDouble("salary");
		double comm = rs.getDouble("comm");
		Emp emp = new Emp(empno, ename, mgr, hiredate, deptno, salary, comm);
		return emp;
	}
	
	
	/**
	 * 按照员工号删除员工信息
	 */
	public int delete(int empno) {
		String sql="delete from t_emp where empno=?";
		try(Connection conn=DBUtil.getConnection()){
			PreparedStatement ps=
					conn.prepareStatement(sql);
			ps.setInt(1, empno);
			int n = ps.executeUpdate();
			return n;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 添加新用户功能
	 * 返回添加的行数
	 */
	public int save(Emp emp) {
		//将emp对象中的数据保存到 数据库
		String sql = "insert into t_emp "
				+ "(empno, ename, mgr, hiredate, "
				+ "deptno, salary, comm) values "
				+ "(null, ?,?,?,?,?,? )";
		try(Connection conn=DBUtil.getConnection()){
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ps.setString(1, emp.getEname());
			ps.setInt(2, emp.getMgr());
			ps.setDate(3, emp.getHiredate());
			ps.setInt(4, emp.getDeptno());
			ps.setDouble(5, emp.getSalary());
			ps.setDouble(6, emp.getComm());
			int n = ps.executeUpdate();
			return n;
		}catch(Exception e) {
			e.printStackTrace(); 
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * 从数据库中查询全部的员工数据, 封装到List
	 * 返回, list中的每个元素是一个Emp对象
	 * @return 全部的员工数据
	 */
	public List<Emp> findAll(){
		String sql = "select empno, ename, mgr, "
				+ "hiredate, deptno, salary, comm "
				+ "from t_emp";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<Emp> list = new ArrayList<>();
			while(rs.next()) {
				Emp emp = row2Emp(rs);
				list.add(emp);
 			}
			return list;//正常结果
		} catch (Exception e) {
			e.printStackTrace();
			//错误情况!
			throw new RuntimeException(e); //错误结果
		} finally {
			DBUtil.close(conn); 
		}
	}
}












