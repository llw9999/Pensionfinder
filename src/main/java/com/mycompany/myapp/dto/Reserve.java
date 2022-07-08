package com.mycompany.myapp.dto;

import java.sql.Date;

public class Reserve {
	private int rnum;
	private int pnum;
	private String startdate;
	private String enddate;
	private String memail;
	
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
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	@Override
	public String toString() {
		return "Reserve [rnum=" + rnum + ", pnum=" + pnum + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", memail=" + memail + "]";
	}
	
}
