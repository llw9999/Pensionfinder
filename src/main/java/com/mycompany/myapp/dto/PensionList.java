package com.mycompany.myapp.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class PensionList {
	private String pemail;
	private String subject;
	private String zipcode;
	private String addrdetail;
	private String addrload;
	private String pphone;
	private int pprice;
	private String region;
	private int pnum;
	private String pcontent;
	private int likes;
	private int dislikes;
	private String removeyn;
	List<MultipartFile> files; //파일들
	private String poption;
	
	public String getPemail() {
		return pemail;
	}
	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public String getPphone() {
		return pphone;
	}
	public void setPphone(String pphone) {
		this.pphone = pphone;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	public String getRemoveyn() {
		return removeyn;
	}
	public void setRemoveyn(String removeyn) {
		this.removeyn = removeyn;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	public String getPoption() {
		return poption;
	}
	public void setPoption(String poption) {
		this.poption = poption;
	}
	@Override
	public String toString() {
		return "PensionList [pemail=" + pemail + ", subject=" + subject + ", zipcode=" + zipcode + ", addrdetail="
				+ addrdetail + ", addrload=" + addrload + ", pphone=" + pphone + ", pprice=" + pprice + ", region="
				+ region + ", pnum=" + pnum + ", pcontent=" + pcontent + ", likes=" + likes + ", dislikes=" + dislikes
				+ ", removeyn=" + removeyn + ", files=" + files + ", poption=" + poption + "]";
	}

	
}