package member.controller;

import java.util.Scanner;

import member.model.vo.Member;

public class MemberManager {
	private Scanner sc = new Scanner(System.in);
	private Member[] m = new Member[10];
	private static int cnt = 0; //회원관리 기능 제공용 클래스

	public MemberManager() {}



	public void insertMember() {
		System.out.println("Id를 입력하세요: ");
		String userId = sc.next();
		System.out.println("Pwd를 입력하세요: ");
		String userPwd = sc.next();
		System.out.println("이름을 입력하세요: ");
		String userName = sc.next();
		System.out.println("나이를 입력하세요: ");
		int age = sc.nextInt();
		System.out.println("성별을 입력하세요 (M/F): ");
		char gender =sc.next().charAt(0);
		System.out.println("이메일을 입력하세요: ");
		String email = sc.next();
		m[0] = new Member(userId,userPwd,userName,age,gender,email);
		cnt++;
		System.out.println("입력이 완료되었습니다. 메인메뉴로 돌아갑니다");
	}

	public void printAllMember() {
		//반복문을 이용하여 cnt까지의 모든 인덱스의 객체 정보를 getter를 통해 출력시키는 메소드
		for(int i = 0; i <cnt; i++) {
			System.out.println("ID: " +m[i].getUserId()+ " Pwd: " +m[i].getUserPwd()+ " name: " +m[i].getUserName()+ 
					" Name: " +m[i].getUserName()+ "Age: " +m[i].getAge()+ " Gender: " +m[i].getGender()+ "Email: " +m[i].getEmail());
			
		}
	}

	public void printOne(Member m) {
		//출력시킬 Member객체를 전달받아, 해당 객체의 getter를 이용하여 전달받은 객체 정보를 출력함
		System.out.println("id: " + m.getUserId() + " Pwd: " + m.getUserPwd() 
		+ " name: " + m.getUserName()+ " age: " + m.getAge() + " gender: " 
		+ m.getGender() +" Email: " + m.getEmail());
	}

	public void searchId() {
		System.out.println("검색할 아이디를 입력하세요: ");
		String userId = sc.next();

		for(int i = 0; i<m.length; i++) {
			if(m[i].getUserId().equals(userId)) {
				printOne(m[i]);
			} else {
				System.out.println("검색한 정보가 존재하지 않습니다.");
				return;
			}

		}

	}

	public void searchName() {
		System.out.println("검색할 이름을 입력하세요: ");
		String userName = sc.next();

		for(int i = 0; i<m.length; i++) {
			if(m[i].getUserName().equals(userName)) {
				printOne(m[i]);
			} else {
				System.out.println("검색한 회원정보가 존재하지 않습니다.");
				return;
			}

		}
	}

	public void searchEmail() {
		System.out.println("검색할 이메일을 입력하세요: ");
		String userEmail = sc.next();

		for(int i = 0; i<m.length; i++) {
			if(m[i].getEmail().equals(userEmail)) {
				printOne(m[i]);
			} else {
				System.out.println("검색한 회원정보가 존재하지 않습니다.");
				return;
			}

		}
	}

	public void updatePwd() {
		//"수정할 회원의 아이디를 입력하세요 : " 출력 후 키보드로 아이디 입력 받음
		System.out.println("수정할 회원의 아이디를 입력하세요");
		String userId = sc.next();
		for(int i = 0; i<m.length; i++) {
			if(m[i].getUserId().equals(userId)) {
				System.out.println("변경 할 비밀번호를 입력하세요.");
				String userPwd = sc.next();
				m[i].setUserPwd(userPwd); 
				System.out.println("패스워드 변경이 완료 되었습니다.");
			} else {
				System.out.println("수정할 회원정보가 존재하지 않습니다.");
				return;
			}

		}
	}
	public void updateName() {

		System.out.println("수정할 회원의 아이디를 입력하세요");
		String userId = sc.next();
		for(int i = 0; i<m.length; i++) {
			if(m[i].getUserId().equals(userId)) {
				System.out.println("변경 할 이름을 입력하세요.");
				String userName = sc.next();
				m[i].setUserName(userName); 
				System.out.println("이름 변경이 완료 되었습니다.");
			} else {
				System.out.println("수정할 회원정보가 존재하지 않습니다.");
				return;
			}

		}
	}
	public void updateEmail() {
		System.out.println("수정할 회원의 아이디를 입력하세요");
		String userId = sc.next();
		for(int i = 0; i<m.length; i++) {
			if(m[i].getUserId().equals(userId)) {
				System.out.println("변경 할 이름을 입력하세요.");
				String userEmail = sc.next();
				m[i].setEmail(userEmail); 
				System.out.println("이름 변경이 완료 되었습니다.");
			} else {
				System.out.println("수정할 회원정보가 존재하지 않습니다.");
				return;
			}
		}
	}
	public void deleteOne() {
		System.out.println("탈퇴할 회원의 아이디를 입력하세요 : ");
		String userId = sc.next();

		for(int i = 0; i<m.length; i++) {
			if(m[i].getUserId().equals(userId)) {
				m[i] = m[i+1];
				cnt --;

			} else {
				System.out.println("삭제할 회원 정보가 없습니다.");

			}
		}
	}

	public void deleteAll() {
		for(int i = 0; i< cnt; i++) {
			m[i].setUserId(null); 
			m[i].setUserPwd(null); 
			m[i].setUserName(null);
			m[i].setAge(0); 
			m[i].setGender(' ');
			m[i].setEmail(null);

			cnt = 0;
		}
	}


}
