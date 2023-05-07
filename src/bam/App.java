package bam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bam.controller.ArticleController;
import bam.controller.MemberController;
import bam.dto.Article;
import bam.dto.Member;
import bam.util.Util;

public class App {

	List<Article> articles;
	List<Member> members;

	
	App() {
		articles = new ArrayList<>();
		members = new ArrayList<>();


	}

	
	public void run() {
		
		System.out.println("=== 프로그램 시작 ====");
		
		Scanner sc = new Scanner(System.in);
		
		
		
		MemberController memberController = new MemberController( members, sc );
		ArticleController articleController = new ArticleController( articles, sc );
		
		articleController.makeTestData();

		
		while (true) {
			String cmd = sc.nextLine().trim();
				
			if( cmd.equals("exit") ) {
				break;
			}

			if( cmd.equals("member join") ) {
				memberController.doJoin();
			}
			else if( cmd.equals("member list") ) {
				
				System.out.println(" ==== 멤버 LIST ====");
				
				System.out.println(" ==== artilce LIST ====");
				System.out.printf("ID	제목	타이틀	등록일\n");
				for ( int i = members.size() -1 ; i>=0; i-- ) {
					Member member = members.get(i);
					System.out.printf("%d	%s	%s	%s\n", member.getId(), member.getLogInId(), member.getName() , member.getRegDate() );
				}

				
			}	

			else if( cmd.equals("article write") ) {
				articleController.doWrite();
				
			} else if ( cmd.startsWith("article list")) {
				articleController.showList(cmd);
				
			} else if ( cmd.startsWith("article detail")) {
				articleController.showDetail(cmd);
				
		  } else if ( cmd.startsWith("article modify")) {
			  articleController.doModify(cmd);
			  
			
		 } else if ( cmd.startsWith("article delete")) {
			 articleController.doDelete(cmd);
			 
			
		}
			else {
				System.out.println("명령어를 잘못 입력 하였습니다");
				
			}
		}
		
		sc.close();
		
		System.out.println("=== 프로그램 종료 ====");
	}

	
	


}
