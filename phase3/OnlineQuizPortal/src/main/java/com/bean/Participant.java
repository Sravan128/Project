package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Participant {

	@Id
	private String email;
	private int pid;
	private String name;
	private int age;
	private String password;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Participant [pid=" + pid + ", name=" + name + ", age=" + age + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
}
