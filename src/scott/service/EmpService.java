package scott.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import scott.dao.EmpDAO;
import scott.dto.Emp;

public class EmpService {

	EmpDAO dao = new EmpDAO();

	
	public void deleteEmp(Scanner scan) {
		System.out.println("사원 정보 삭제(퇴사)");
		System.out.print("사원번호 > ");
		int empno = scan.nextInt();
		System.out.print("이름 > ");
		String ename = scan.next();
		
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("empno",empno);
		m.put("ename", ename);
		
		int i = dao.deleteEmp(m);
		
		if( i == 0 ) {
			System.out.println("사원번호나 이름이 틀림(삭제 안됨).");
		}else {
			System.out.println(empno +"사원의 정보가 삭제 됨");
		}
	}
	
	public void updateSal(Scanner scan) {
		System.out.println("사원 급여 인상");
		System.out.print("사원번호 > ");
		int empno = scan.nextInt();
		System.out.print("인상된 급여");
		int newsal = scan.nextInt();
		
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("empno", empno);
		m.put("newsal", newsal);
		
		int i = dao.updateSal(m);
		
		if( i == 0) {
			System.out.println(empno +" : 사번 없음");
		}else {
			System.out.printf("%d 사원의 급여가 변경됨 : %d \n",
					empno, newsal);
		}
	}
	
	
	
	public void updateDept(Scanner scan) {
		System.out.println("사원의 부서를 이동");
		System.out.print("사원번호 > ");
		int empno = scan.nextInt();
		System.out.print("이동할 부서 번호");
		int newno = scan.nextInt();
		
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("empno", empno);
		m.put("newno", newno);
		
		int i = dao.updateDept(m);
		
		if( i == 0) {
			System.out.println(empno +" : 사번 없음");
		}else {
			System.out.printf("%d 사원의 부서가 변경됨 : %d \n",
					empno, newno);
		}
	}
	
	public void search2(Scanner scan) {
		System.out.println("사원의 이름으로 조회(like)");
		System.out.print("사원 이름 >");
		String name = scan.next();
		
		List<Emp> result = dao.search2(name);
		for(Emp e : result) {
			System.out.println(e);
		}
		
	}
	
	public void search1(Scanner scan) {
		System.out.println("사원 조회(사원 번호 입력)");
		System.out.print("사원 번호 > ");
		int empno = scan.nextInt();

		Map<String, Object> emp = dao.search1(empno);
		if (emp != null) {
			System.out.println("사번 : " + emp.get("EMPNO"));
			System.out.println("사원명 : " + emp.get("ENAME"));
			System.out.println("부서명 : " + emp.get("DNAME"));
			System.out.println("근무지 : " + emp.get("LOC"));
		}else {
			System.out.println(empno +" :해당 사번은 없습니다.");
		}
	}

	public void emps() {
		System.out.println("전체 사원 정보 조회");
		List<Emp> elist = dao.emps();
		for (Emp e : elist) {
			System.out.println(e);
		}

	}

}
