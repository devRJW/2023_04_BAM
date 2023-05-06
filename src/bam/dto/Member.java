package bam.dto;

public class Member  {
	public int id;
	public String logInId;
	public String logPw;
	public String logpwChk;
	public String name;
	public String regDate;
	
	public Member() {
	}

	public Member(int id, String regDate, String logInId, String logPw, String name) {
		this.id  = id;
		this.regDate  = regDate;
		this.logInId  = logInId;
		this.logPw  = logPw;
		this.name  = name;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogInId() {
		return logInId;
	}

	public void setLogInId(String logInId) {
		this.logInId = logInId;
	}

	public String getLogPw() {
		return logPw;
	}

	public void setLogPw(String logPw) {
		this.logPw = logPw;
	}

	public String getLogpwChk() {
		return logpwChk;
	}

	public void setLogpwChk(String logpwChk) {
		this.logpwChk = logpwChk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", logInId=" + logInId + ", logPw=" + logPw + ", logpwChk=" + logpwChk + ", name="
				+ name + ", regDate=" + regDate + "]";
	}
	
}
