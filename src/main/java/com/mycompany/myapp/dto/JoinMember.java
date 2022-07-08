package com.mycompany.myapp.dto;

public class JoinMember {
	private String memail;
	private String mname;
	private String mpasswd;
	private String memailauth;
	
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpasswd() {
		return mpasswd;
	}
	public void setMpasswd(String mpasswd) {
		this.mpasswd = mpasswd;
	}
	public String getMemailauth() {
		return memailauth;
	}
	public void setMemailauth(String memailauth) {
		this.memailauth = memailauth;
	}
	
	@Override
	public String toString() {
		return "Member [memail=" + memail + ", mname=" + mname + ", mpasswd=" + mpasswd + ", memailauth=" + memailauth
				+ "]";
	}
	
}
