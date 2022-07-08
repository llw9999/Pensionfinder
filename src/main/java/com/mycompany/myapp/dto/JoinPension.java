package com.mycompany.myapp.dto;

public class JoinPension {
	private String pemail;
	private String pname;
	private String ppasswd;
	private String zipcode;
	private String addrload;
	private String addrdetail;
	private String pemailauth;
	
	public String getPemail() {
		return pemail;
	}
	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPpasswd() {
		return ppasswd;
	}
	public void setPpasswd(String ppasswd) {
		this.ppasswd = ppasswd;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddrload() {
		return addrload;
	}
	public void setAddrload(String addrload) {
		this.addrload = addrload;
	}
	public String getAddrdetail() {
		return addrdetail;
	}
	public void setAddrdetail(String addrdetail) {
		this.addrdetail = addrdetail;
	}
	public String getPemailauth() {
		return pemailauth;
	}
	public void setPemailauth(String pemailauth) {
		this.pemailauth = pemailauth;
	}
	@Override
	public String toString() {
		return "JoinPension [pemail=" + pemail + ", pname=" + pname + ", ppasswd=" + ppasswd + ", zipcode=" + zipcode
				+ ", addrload=" + addrload + ", addrdetail=" + addrdetail + ", pemailauth=" + pemailauth + "]";
	}
	
	 
}
