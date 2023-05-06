package bam.controller;

import java.util.List;
import java.util.Scanner;

import bam.dto.Member;
import bam.util.Util;

public class MemberController {
	
	private List<Member> members;
	private Scanner sc;
	private int lastMemberId ;
	
	public MemberController( List<Member> members, Scanner sc) {
		this.members = members;
		this.sc  = sc;
		lastMemberId = 0;
	}
	
	public void doJoin(  ) {
		int id  =  lastMemberId  + 1; 
		lastMemberId  = id;  
		
		System.out.println(" ==== 멤버 JOIN ====");
		String logInId;
		
		
		while (true) {
			System.out.println("로그인ID");
			logInId = sc.nextLine();
			
			if (logInId.trim().length() == 0) {
				System.out.println("로그인ID를 입력 하세요\n");
				continue;
			}
			
			
			if (isLoginDupChk(members, logInId) ) {
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
			
			if ( loginPwChk.equals(loginPw) == false ) {
				System.out.println("비밀번호 확인이 잘못 되었습니다");
				continue;
			}
			break;
		}
		
		System.out.println("이름");
		String name =  sc.nextLine();
		
		System.out.printf("%d가 회원 가입 되었습니다\n", lastMemberId);
		
		Member member = new Member(id, Util.getDateStr(), logInId, loginPw ,name );
		
		members.add(member);
	}
	
	private boolean isLoginDupChk(List<Member>members, String logInId ) {
		
		for (Member member : members) {
			if( member.logInId.equals(logInId)  ) {
				return true;
			}
		}
		return false;
		
	}


}
