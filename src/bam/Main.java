package bam;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * git add .
 * git commit -m "article detail 반영"
 * git push origin master
 *  */ 



public class Main {
	public static void main(String[] args) {
		
		System.out.println("=== 프로그램 시작 ====");
		
		Scanner sc = new Scanner(System.in);
		List<Article> articles = new ArrayList<>();
		
		int lastArticleId = 0;
		while (true) {
			String cmd = sc.nextLine().trim();
				
			if( cmd.equals("exit") ) {
				break;
			}
			
			if( cmd.equals("article write") ) {
				int id  =  lastArticleId  + 1; 
				lastArticleId  = id;  
				
				System.out.println(" ==== artilce 등록 ====");
				System.out.println("제목");
				String title = sc.nextLine();
				
				System.out.println("타이틀");
				String body = sc.nextLine();
				
				String regDate = Util.getDateStr();
				System.out.printf("regDate:%s ", regDate);
				
				System.out.printf("%d 번 게시글 입니다", lastArticleId);
				
				Article article = new Article(id, title, body, regDate);
				articles.add(article);
			} else if ( cmd.equals("article list")) {
				if ( articles.size() == 0 ) {
					System.out.println("존재하는 게시물이 없습니다");
					continue;
				}
				for ( int i = articles.size() -1 ; i>=0; i-- ) {
					Article article = articles.get(i);
					System.out.println(" ==== artilce LIST ====");
					System.out.printf("ID	제목	타이틀	등록일\n");
					System.out.printf("%d	%s	%s	%s\n", article.getId(), article.getTitle(), article.getTitle() , article.getRegDate() );
				}
				
			} else if ( cmd.startsWith("article detail")) {
				String cmdBits[] = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);  
			 
				/*
				 * for ( int i=0; i < cmdBits.length; i++ ) { System.out.println( "cmdBits[i]:"
				 * + cmdBits[i]); }
				 * 
				*/
				Article foundArticle =  null;

				for (Article article : articles) {
					if( article.getId() == id  ) {
						foundArticle = article;
						break;
					}
				}
				
				if ( foundArticle == null) {
					System.out.printf("%d번 게시물이 존재 하지 않습니다.",id );
					continue;
				}	
				
				System.out.println(" ==== artilce 상세 ====");
				System.out.printf("id   : %d\n" , foundArticle.id );
				System.out.printf("제목 : %s\n" , foundArticle.title );
				System.out.printf("내용 : %s\n" , foundArticle.body );
				System.out.printf("등록일 : %s\n" , foundArticle.regDate );
				
			}
			else {
				System.out.println("명령어를 잘못 입력 하였습니다");
				
			}
		}
		
		sc.close();
		
		System.out.println("=== 프로그램 종료 ====");
	}
}

class Article  {
	int id;
	String title;
	String body;
	String regDate;
	
	public Article() {
	}

	public Article(int id, String title, String body, String regDate) {
		this.id  = id;
		this.title  = title;
		this.body  = body;
		this.regDate  = regDate;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
