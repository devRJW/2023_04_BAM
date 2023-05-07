package bam.controller;

import java.util.List;
import java.util.Scanner;

import bam.dto.Member;
import bam.util.Util;

public class MemberController extends Controller {

	private List<Member> members;
	private Scanner sc;
	private int lastMemberId;
	private Member loginedMember;

	public MemberController(List<Member> members, Scanner sc) {
		this.members = members;
		this.sc = sc;
		lastMemberId = 0;
		loginedMember = null;
	}

	@Override
	public void makeTestData() {
		for (int i = 1; i <= 3; i++) {
			int id = lastMemberId + 1;
			lastMemberId = id;

			String loginId = "test" + i;
			String loginPw = "test" + i;
			String name = "홍길동" + i;

			Member member = new Member(id, Util.getDateStr(), loginId, loginPw, name);
			members.add(member);
		}
		System.out.println("멤버 자료가 3건 생성 되었습니다.");

	}

	@Override
	public void doAction(String cmd, String methodName) {
		switch (methodName) {
		case "join":
			doJoin();
			break;
		case "login":
			doLogin();
			break;
		case "list":
			showList();
			break;
		default:
			System.out.println("메소드 명령어를 잘못입력 하였습니다.");
			break;
		}

	}

	private void showList() {
		System.out.println(" ==== 멤버 LIST ====");

		System.out.printf("ID	로그인아이디 이름	등록일\n");
		for (int i = members.size() - 1; i >= 0; i--) { 
			Member member = members.get(i);
			System.out.printf("%d	%s	%s	%s\n", member.getId(), member.getLogInId(), member.getName(), member.getRegDate());
		}

	}

	private void doLogin() {
		if ( loginedMember != null) {
			System.out.println("로그아웃 후 이용해주세요.");
			return;
		}
		
		System.out.printf("로그인 아이디 :");
		String logInId = sc.nextLine();
		System.out.printf("로그인 비밀번호 :");
		String logInPw = sc.nextLine();

		Member member = getMemberByLoginId(logInId);
		if (member == null) {
			System.out.println("일치하는 회원이 없습니다");
			return;
		}

		if (member.logPw.equals(logInPw) == false) {
			System.out.println("비밀번호를 확인해주세요.");
			return;
		}
		
		loginedMember = member;
		
		System.out.printf("%s 님 환영합니다.", member.name);

	}


	public void doJoin() {
		
		if ( loginedMember != null) {
			System.out.println("로그아웃 후 이용해주세요.");
			return;
		}
		
		int id = lastMemberId + 1;
		lastMemberId = id;

		System.out.println(" ==== 회원 가입 ====");
		String logInId;

		while (true) {
			System.out.println("로그인ID");
			logInId = sc.nextLine();

			if (logInId.trim().length() == 0) {
				System.out.println("로그인ID를 입력 하세요\n");
				continue;
			}

			if (isLoginDupChk(logInId)) {
				System.out.printf("%s은 로그인ID가 존재 합니다\n", logInId);
				continue;
			}

			System.out.printf("%s사용 가능한 ID입니다.\n", logInId);
			break;

		}

		String loginPw;

		while (true) {
			System.out.println("비밀번호");
			loginPw = sc.nextLine();

			System.out.println("비밀번호확인");
			String loginPwChk = sc.nextLine();

			if (loginPwChk.equals(loginPw) == false) {
				System.out.println("비밀번호 확인이 잘못 되었습니다");
				continue;
			}
			break;
		}

		System.out.println("이름");
		String name = sc.nextLine();

		System.out.printf("%d가 회원 가입 되었습니다\n", lastMemberId);

		Member member = new Member(id, Util.getDateStr(), logInId, loginPw, name);

		members.add(member);
	}

	private boolean isLoginDupChk(String logInId) {

		Member member =  getMemberByLoginId(logInId);
			
		if (member.logInId.equals(logInId)) {
			return true;
		}
		return false;

	}

	private Member getMemberByLoginId(String logInId) {
		for (Member member : members) {
			if (member.logInId.equals(logInId)) {
				return member;
			}
		}
		return null;
	}

}
