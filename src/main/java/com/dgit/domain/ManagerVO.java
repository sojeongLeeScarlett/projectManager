package com.dgit.domain;

import java.util.Date;

public class ManagerVO {
	private int number;
	private String name;
	private String content;
	private Date startdate;
	private Date enddate;
	private String progress;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	
	@Override
	public String toString() {
		return "Project [number=" + number + ", name=" + name + ", content=" + content + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", progress=" + progress + "]";
	}
	
	
}
