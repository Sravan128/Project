package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Userquiz {

	@Id
	private int uqid;
	private String email;
	private int qzid;
	private int qid;
	private String usercorrectans;
	public int getUqid() {
		return uqid;
	}
	public void setUqid(int uqid) {
		this.uqid = uqid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getQzid() {
		return qzid;
	}
	public void setQzid(int qzid) {
		this.qzid = qzid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getUsercorrectans() {
		return usercorrectans;
	}
	public void setUsercorrectans(String usercorrectans) {
		this.usercorrectans = usercorrectans;
	}
	
	
}
