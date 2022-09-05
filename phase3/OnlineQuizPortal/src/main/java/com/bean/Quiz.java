package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Quiz {
	@Id
	private int qzid;
	private String subject;
	private int qid;
	public int getQzid() {
		return qzid;
	}
	public void setQzid(int qzid) {
		this.qzid = qzid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	@Override
	public String toString() {
		return "Quiz [qzid=" + qzid + ", subject=" + subject + ", qid=" + qid + "]";
	}
	

}
