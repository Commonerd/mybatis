package scott.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.session.SqlSession;

import scott.dto.Dept;
import scott.mapper.DeptMapper;
import scott.provider.SqlSessionFactoryMake;

public class DeptMapperDAO {
	// @Select("select * from dept")
	// List<Dept> depts();

	public List<Dept> depts(){
		SqlSession session = SqlSessionFactoryMake.getFactory().openSession();
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		try {
			return mapper.depts();
		}finally {
			session.close();
		}
	}
	//@Select("selet * from dept where deptno = #{deptno}")
	//Dept deptOne(int deptno);
	
	public Dept deptOne(int deptno) {
		SqlSession session = SqlSessionFactoryMake.getFactory().openSession();
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		try {
			return mapper.deptOne(deptno);
		}finally {
			session.close();
		}
	}
	
	//@Insert("insert into dept values(#{deptno},#{dname,#{loc})")
	//int insertDept(Dept dto);
	
	public int insertDept(Dept dto) {
		SqlSession session = SqlSessionFactoryMake.getFactory().openSession();
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		try {
			return mapper.insertDept(dto);
		}finally {
			session.commit();
			session.close();
		}
	}
}