package scott.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import scott.dto.Emp;
import scott.provider.SqlSessionFactoryMake;

public class EmpDAO {
	
	public int deleteEmp(Map<String, Object> m) {
		SqlSession session = SqlSessionFactoryMake.getFactory().openSession();
		try {
			return session.delete("scott.emp.deleteEmp", m);
		}finally {
			session.commit();
			session.close();
		}
		
	}
	
	public int updateSal(Map<String,Object> m) {
		SqlSession session = SqlSessionFactoryMake.getFactory().openSession();
		try {
			return session.update("scott.emp.updateSal",m);
		}finally {
			session.commit();
			session.close();
		}
	}
	
	public int updateDept(Map<String,Object> m) {
		SqlSession session = SqlSessionFactoryMake.getFactory().openSession();
		try {
			return session.update("scott.emp.updateDept",m);
		}finally {
			session.commit();
			session.close();
		}
	}
	
	public List<Emp> search2(String name){
		SqlSession session = SqlSessionFactoryMake.getFactory().openSession();
		try {
			return session.selectList("scott.emp.search2",name);
		}finally {
			session.close();
		}
	}
	
	public Map<String, Object> search1(int empno) {
		SqlSession session = SqlSessionFactoryMake.getFactory().openSession();
		try {
			Map<String, Object> map =  session.selectOne("scott.emp.search1",empno);
			return map;
		} finally {
			session.close();
		}
	}
	
	public List<Emp> emps() {
		SqlSession session = SqlSessionFactoryMake.getFactory().openSession();
		try {
		
			List<Emp> elist = session.selectList("scott.emp.emps");
			return elist;
		
		} finally {
			session.close();
		}
	}
}
