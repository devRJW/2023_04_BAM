package bam.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bam.dto.Article;
import bam.util.Util;

public class ArticleController {
	
	private List<Article> articles;
	private Scanner sc;
	private int lastArticleId ;
	
	public ArticleController( List<Article> articles, Scanner sc) {
		this.articles = articles;
		this.sc  = sc;
		lastArticleId = 0;
	}
	

	public void doWrite() {
		
		int id  =  lastArticleId  + 1; 
		lastArticleId  = id;  
		
		System.out.println(" ==== artilce 등록 ====");
		System.out.println("로그인ID");
		String title = sc.nextLine();
		
		System.out.println("타이틀");
		String body = sc.nextLine();
		
		System.out.printf("regDate:%s ", body);
		
		System.out.printf("%d 번 게시글 입니다", lastArticleId);
		
		Article article = new Article(id, Util.getDateStr(),  title, body );
		articles.add(article);

		
	}


	public void showList(String cmd) {
		List<Article> findArticles =  articles;
		
		String serchTitle  = cmd.substring("article list".length()).trim();
		
		if ( serchTitle.length() > 0 ) {
			findArticles = new ArrayList<>();
			
			for (Article article : articles) {
				if( article.title.contains(serchTitle) ) {
					findArticles.add(article);
				}
			}
			
			if ( articles.size() == 0 ) {
				System.out.println("존재하는 게시물이 없습니다");
				return;
			}
			
		}
		
		System.out.println(" ==== artilce LIST ====");
		System.out.printf("ID	제목	타이틀	등록일\n");
		for ( int i = findArticles.size() -1 ; i>=0; i-- ) {
			Article article = findArticles.get(i);
			System.out.printf("%d	%s	%s	%s\n", article.getId(), article.getTitle(), article.getBody() , article.getRegDate() );
		}

		
	}


	public void showDetail(String cmd) {
		String cmdBits[] = cmd.split(" ");
		if (cmdBits.length != 3 ) {
			System.out.println( "id를 입력 하지 않았습니다" );
			return;
		}

		int id = Integer.parseInt(cmdBits[2]);  
	 
		/*
		 * for ( int i=0; i < cmdBits.length; i++ ) { System.out.println( "cmdBits[i]:"
		 * + cmdBits[i]); }
		 * 
		*/
		Article foundArticle =  getArticleId(id);

		if ( foundArticle == null) {
			System.out.printf("%d번 게시물이 존재 하지 않습니다.",id );
			return;
		}	
		
		System.out.println(" ==== artilce 상세 ====");
		System.out.printf("id   : %d\n" , foundArticle.getId() );
		System.out.printf("제목 : %s\n" , foundArticle.getTitle() );
		System.out.printf("내용 : %s\n" , foundArticle.getBody() );
		System.out.printf("등록일 : %s\n" , foundArticle.getRegDate() );
		
	}
	
	private Article getArticleId(int id) {
		for (Article article : articles) {
			if( article.getId() == id  ) {
				return  article;
			}
		}
		
		return null;
	}


	public void doModify(String cmd) {
		String cmdBits[] = cmd.split(" ");
		
		if (cmdBits.length != 3 ) {
			System.out.println( "id를 입력 하지 않았습니다" );
			return;
		}

		int id = Integer.parseInt(cmdBits[2]);
		
		
	 
		/*
		 * for ( int i=0; i < cmdBits.length; i++ ) { System.out.println( "cmdBits[i]:"
		 * + cmdBits[i]); }
		 * 
		*/
		Article foundArticle =  getArticleId(id);

		
		if ( foundArticle == null) {
			System.out.printf("%d번 게시물이 존재 하지 않습니다.",id );
			return;
		}	
		
		
		System.out.println(" ==== artilce 수정 ====");
		System.out.println("제목");
		String title = sc.nextLine();
		
		System.out.println("타이틀");
		String body = sc.nextLine();
		
		foundArticle.setTitle(title);
		foundArticle.setBody(body);
		
		System.out.printf("%d번 게시물이 수정 되었습니다.",id );

		
	}


	public void doDelete(String cmd) {
		String cmdBits[] = cmd.split(" ");
		if (cmdBits.length != 3 ) {
			System.out.println( "id를 입력 하지 않았습니다" );
			return;
		}
		
		int id = Integer.parseInt(cmdBits[2]);  
		
		
	 
		/*
		 * for ( int i=0; i < cmdBits.length; i++ ) { System.out.println( "cmdBits[i]:"
		 * + cmdBits[i]); }
		 * 
		*/
		Article foundArticle =  getArticleId(id);
		
		if ( foundArticle == null) {
			System.out.printf("%d번 게시물이 존재 하지 않습니다.",id );
			return;
		}	
		
		
		articles.remove(foundArticle);
		
		System.out.printf("%d번 게시물이 삭제 되었습니다.",id );

		
	}


	public  void makeTestData() {
		
			
		for (int i = 1; i <= 5; i++) {
			
			int id  =  lastArticleId  + 1; 
			lastArticleId  = id;  
			
			String title = "title" + i;
			String body = "body" + i;
			
			Article article = new Article(id, Util.getDateStr() ,title,body );
			articles.add(article);
			
		}
		
	}
}
