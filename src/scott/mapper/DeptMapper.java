package scott.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import scott.dto.Dept;
//
@Mapper //해당 sql문이 실행될 수 있도록 자동으로 구현(구현 객체 생성)
public interface DeptMapper {
	
	@Select ("select * from dept") 
	List<Dept> depts(); 
	
	@Select("select * from dept where deptno = #{deptno}")
	Dept deptOne(int deptno);//받아오는 값 하나면 인트
	
	@Insert("insert into dept values(#{deptno},#{dname,#{loc})")
	int insertDept(Dept dto);
	// 그냥 외우기: insert update delete는 int로 받는다.
	@Update("update dept set loc=#{loc} where deptno = #{deptno})")
	int updateLoc(Map<String, Object> m); //맵 객체를 받아오는 것
		
	@Delete("delete from dept where deptno = #{deptno})")
	int deleteDept(int deptno);//받아오는 값 하나, 그래서 int
	
	@Select("select ename from emp natural join dept where deptno = #{deptno})")
	List<String> enames(int deptno); //리턴타입 이름 매개변수의 순서 -> 동적sql문 만들때 복잡해지는 단점.
	//Dept deptOne(Map<String, Object> m); //문제점: 받아오는 값이 여러개다. 그러면 어떻게 하지?
}
