package entity;

import java.sql.Date;

/**
 * 创建员工类, 封装员工数据 
 * 业务实体(entity)类, 封装业务数据的类 
 * 生成 有参构造器,  get set 方法, 生成toString
 */
public class Emp {
	private int empno;
	private String ename;
	private int mgr;
	private Date hiredate;
	private int deptno;
	private double salary;
	private double comm;
	
	public Emp() {
	}

	public Emp(int empno, String ename, int mgr, Date hiredate, int deptno, double salary, double comm) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptno = deptno;
		this.salary = salary;
		this.comm = comm;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", mgr=" + mgr + ", hiredate=" + hiredate + ", deptno="
				+ deptno + ", salary=" + salary + ", comm=" + comm + "]";
	}



}









