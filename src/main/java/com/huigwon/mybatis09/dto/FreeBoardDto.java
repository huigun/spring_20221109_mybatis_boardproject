package com.huigwon.mybatis09.dto;

public class FreeBoardDto {
	int fnum;
	int fhit;
	String fid;
	String fname; 
	String ftitle; 
	String fcontent;
	String fdate;
	
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public int getFhit() {
		return fhit;
	}
	public void setFhit(int fhit) {
		this.fhit = fhit;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	
	public FreeBoardDto(int fnum, int fhit, String fname, String ftitle, String fcontent, String fdate, String fid) {
		super();
		this.fnum = fnum;
		this.fhit = fhit;
		this.fname = fname;
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.fdate = fdate;
		this.fid = fid;
	}
	public FreeBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
