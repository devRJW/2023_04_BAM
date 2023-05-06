package bam.dto;

public class Article  {
	public int id;
	public String title;
	public String body;
	public String regDate;
	
	public Article() {
	}

	public Article(int id,  String regDate, String title, String body) {
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

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", body=" + body + ", regDate=" + regDate + "]";
	}
	
	
}
