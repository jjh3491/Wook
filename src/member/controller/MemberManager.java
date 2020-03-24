package member.controller;

import java.util.Scanner;

import member.model.vo.Member;

public class MemberManager {
	private Scanner sc = new Scanner(System.in);
	private Member[] m = new Member[10];
	private static int cnt = 0; //ȸ������ ��� ������ Ŭ����

	public MemberManager() {}



	public void insertMember() {
		System.out.println("Id�� �Է��ϼ���: ");
		String userId = sc.next();
		System.out.println("Pwd�� �Է��ϼ���: ");
		String userPwd = sc.next();
		System.out.println("�̸��� �Է��ϼ���: ");
		String userName = sc.next();
		System.out.println("���̸� �Է��ϼ���: ");
		int age = sc.nextInt();
		System.out.println("������ �Է��ϼ��� (M/F): ");
		char gender =sc.next().charAt(0);
		System.out.println("�̸����� �Է��ϼ���: ");
		String email = sc.next();
		m[0] = new Member(userId,userPwd,userName,age,gender,email);
		cnt++;
		System.out.println("�Է��� �Ϸ�Ǿ����ϴ�. ���θ޴��� ���ư��ϴ�");
	}

	public void printAllMember() {
		//�ݺ����� �̿��Ͽ� cnt������ ��� �ε����� ��ü ������ getter�� ���� ��½�Ű�� �޼ҵ�
		for(int i = 0; i <cnt; i++) {
			System.out.println("ID: " +m[i].getUserId()+ " Pwd: " +m[i].getUserPwd()+ " name: " +m[i].getUserName()+ 
					" Name: " +m[i].getUserName()+ "Age: " +m[i].getAge()+ " Gender: " +m[i].getGender()+ "Email: " +m[i].getEmail());
			
		}
	}

	public void printOne(Member m) {
		//��½�ų Member��ü�� ���޹޾�, �ش� ��ü�� getter�� �̿��Ͽ� ���޹��� ��ü ������ �����
		System.out.println("id: " + m.getUserId() + " Pwd: " + m.getUserPwd() 
		+ " name: " + m.getUserName()+ " age: " + m.getAge() + " gender: " 
		+ m.getGender() +" Email: " + m.getEmail());
	}

	public void searchId() {
		System.out.println("�˻��� ���̵� �Է��ϼ���: ");
		String userId = sc.next();

		for(int i = 0; i<m.length; i++) {
			if(m[i].getUserId().equals(userId)) {
				printOne(m[i]);
			} else {
				System.out.println("�˻��� ������ �������� �ʽ��ϴ�.");
				return;
			}

		}

	}

	public void searchName() {
		System.out.println("�˻��� �̸��� �Է��ϼ���: ");
		String userName = sc.next();

		for(int i = 0; i<m.length; i++) {
			if(m[i].getUserName().equals(userName)) {
				printOne(m[i]);
			} else {
				System.out.println("�˻��� ȸ�������� �������� �ʽ��ϴ�.");
				return;
			}

		}
	}

	public void searchEmail() {
		System.out.println("�˻��� �̸����� �Է��ϼ���: ");
		String userEmail = sc.next();

		for(int i = 0; i<m.length; i++) {
			if(m[i].getEmail().equals(userEmail)) {
				printOne(m[i]);
			} else {
				System.out.println("�˻��� ȸ�������� �������� �ʽ��ϴ�.");
				return;
			}

		}
	}

	public void updatePwd() {
		//"������ ȸ���� ���̵� �Է��ϼ��� : " ��� �� Ű����� ���̵� �Է� ����
		System.out.println("������ ȸ���� ���̵� �Է��ϼ���");
		String userId = sc.next();
		for(int i = 0; i<m.length; i++) {
			if(m[i].getUserId().equals(userId)) {
				System.out.println("���� �� ��й�ȣ�� �Է��ϼ���.");
				String userPwd = sc.next();
				m[i].setUserPwd(userPwd); 
				System.out.println("�н����� ������ �Ϸ� �Ǿ����ϴ�.");
			} else {
				System.out.println("������ ȸ�������� �������� �ʽ��ϴ�.");
				return;
			}

		}
	}
	public void updateName() {

		System.out.println("������ ȸ���� ���̵� �Է��ϼ���");
		String userId = sc.next();
		for(int i = 0; i<m.length; i++) {
			if(m[i].getUserId().equals(userId)) {
				System.out.println("���� �� �̸��� �Է��ϼ���.");
				String userName = sc.next();
				m[i].setUserName(userName); 
				System.out.println("�̸� ������ �Ϸ� �Ǿ����ϴ�.");
			} else {
				System.out.println("������ ȸ�������� �������� �ʽ��ϴ�.");
				return;
			}

		}
	}
	public void updateEmail() {
		System.out.println("������ ȸ���� ���̵� �Է��ϼ���");
		String userId = sc.next();
		for(int i = 0; i<m.length; i++) {
			if(m[i].getUserId().equals(userId)) {
				System.out.println("���� �� �̸��� �Է��ϼ���.");
				String userEmail = sc.next();
				m[i].setEmail(userEmail); 
				System.out.println("�̸� ������ �Ϸ� �Ǿ����ϴ�.");
			} else {
				System.out.println("������ ȸ�������� �������� �ʽ��ϴ�.");
				return;
			}
		}
	}
	public void deleteOne() {
		System.out.println("Ż���� ȸ���� ���̵� �Է��ϼ��� : ");
		String userId = sc.next();

		for(int i = 0; i<m.length; i++) {
			if(m[i].getUserId().equals(userId)) {
				m[i] = m[i+1];
				cnt --;

			} else {
				System.out.println("������ ȸ�� ������ �����ϴ�.");

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
