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
 * ��װ�� Emp ������ݷ��ʹ��� 
 */
public class EmpDao {
	/**
	 * ����ID��ȡһ��Ա����Ϣ
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
				emp = row2Emp(rs); //���� row2Emp ����
			}
			return emp; //�ҵ��������emp����
			//�Ҳ�������null��ʾ"��"�����
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ����ID����Ա����Ϣ
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
	 * ��ȡԱ���е�ȫ���쵼
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
				//������û�б�����󣬲���ѡ���Ĵ�����ܹ���ȡΪ������
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
	 * ����Ա����ɾ��Ա����Ϣ
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
	 * ������û�����
	 * ������ӵ�����
	 */
	public int save(Emp emp) {
		//��emp�����е����ݱ��浽 ���ݿ�
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
	 * �����ݿ��в�ѯȫ����Ա������, ��װ��List
	 * ����, list�е�ÿ��Ԫ����һ��Emp����
	 * @return ȫ����Ա������
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
			return list;//�������
		} catch (Exception e) {
			e.printStackTrace();
			//�������!
			throw new RuntimeException(e); //������
		} finally {
			DBUtil.close(conn); 
		}
	}
}












