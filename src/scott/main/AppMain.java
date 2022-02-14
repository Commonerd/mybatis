package scott.main;

import java.util.Scanner;

import scott.service.DeptService;
import scott.service.EmpService;

public class AppMain {
	public static void main(String[] args) {

		DeptService service = new DeptService();
		EmpService eservice = new EmpService();
		
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		
		System.out.println("1. 전체 부서 정보 출력");
		System.out.println("2. 부서 검색");
		System.out.println("3. 부서 추가");
		System.out.println("4. 전체 사원 조회");
		System.out.println("5. 사원 조회(사원 번호 입력)");
		System.out.println("6. 사원 조회(사원 이름 입력)");
		System.out.println("7. 사원의 부서를 이동");
		System.out.println("8. 사원 급여 인상");
		System.out.println("9. 사원 정보 삭제(퇴사)");
		while (flag) {
			
			System.out.print("메뉴 선택 > ");
			int menu = s.nextInt();

			switch (menu) {
			case 1:
				service.depts(); break;
			case 2:
				service.searchDept(s); break;
			case 3:
				service.addDept(s); break;
			case 4:
				eservice.emps(); break;
			case 5: 
				eservice.search1(s); break;
			case 6: 
				eservice.search2(s); break;
			case 7: 
				eservice.updateDept(s); break;
			case 8: 
				eservice.updateSal(s); break;	
			case 9: 
				eservice.deleteEmp(s); break;	
			default:
				System.out.println("없는 메뉴입니다. 프로그램 종료");
				flag = false;
				break;
			}
		}//while
		s.close();
	}//main

}//class
