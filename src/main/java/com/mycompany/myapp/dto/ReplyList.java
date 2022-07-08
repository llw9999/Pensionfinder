package com.mycompany.myapp.dto;

import java.util.Date;

public class ReplyList {
	private String memail;
	private int rnum;
	private int pnum;
	private int restep;
	private int help;
	private int useless;
	private String rsubject;
	private String rcontent;
	private Date regidate;
	private Date modidate;
	public ReplyList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReplyList(String memail, int rnum, int pnum, int restep, int help, int useless, String rsubject,
			String rcontent, Date regidate, Date modidate) {
		super();
		this.memail = memail;
		this.rnum = rnum;
		this.pnum = pnum;
		this.restep = restep;
		this.help = help;
		this.useless = useless;
		this.rsubject = rsubject;
		this.rcontent = rcontent;
		this.regidate = regidate;
		this.modidate = modidate;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getHelp() {
		return help;
	}
	public void setHelp(int help) {
		this.help = help;
	}
	public int getUseless() {
		return useless;
	}
	public void setUseless(int useless) {
		this.useless = useless;
	}
	public String getRsubject() {
		return rsubject;
	}
	public void setRsubject(String rsubject) {
		this.rsubject = rsubject;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
	@Override
	public String toString() {
		return "ReplyList [memail=" + memail + ", rnum=" + rnum + ", pnum=" + pnum + ", restep=" + restep + ", help="
				+ help + ", useless=" + useless + ", rsubject=" + rsubject + ", rcontent=" + rcontent + ", regidate="
				+ regidate + ", modidate=" + modidate + "]";
	}
	
}
