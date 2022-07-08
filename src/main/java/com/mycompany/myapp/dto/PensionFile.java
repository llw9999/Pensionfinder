package com.mycompany.myapp.dto;

public class PensionFile {
	private int pfnum;
	private int pnum;
	private String filename;
	@Override
	public String toString() {
		return "PensionFile [pfnum=" + pfnum + ", pnum=" + pnum + ", filename=" + filename + "]";
	}
	public int getPfnum() {
		return pfnum;
	}
	public void setPfnum(int pfnum) {
		this.pfnum = pfnum;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public PensionFile(int pfnum, int pnum, String filename) {
		super();
		this.pfnum = pfnum;
		this.pnum = pnum;
		this.filename = filename;
	}
	public PensionFile() {
		super();
		// TODO Auto-generated constructor stub
	}
}
