package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Admin;
import com.bean.Question;
import com.bean.Quiz;
import com.bean.Score;
import com.dao.AdminDao;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;
	
	public String CheckAdmin(Admin ad) {
		if(adminDao.checkAdmin(ad)>0) {
			return "Admin Login Successful";
		}
		else {
			return "Failure! Provide Correct Credentials!";
		}
	}
	
	
	public String updatePassword(Admin ad) {
		Admin a = adminDao.getAdminDetails(ad.getEmail());
		if(a==null) {
			return "Admin details not present, cannot be updated";
		}
		else if(adminDao.updatePassword(ad)>0) {
				return "Password Updated";
			}else {
				return "Password Not Updated";
			}
	}
	
	public String addQuestion(Question qn) {
		if(adminDao.addQuestion(qn)>0) {
			return "Question Added Successfully";
		}
		else {
			return "Question didnt added";
		}
	}
	
	public String addQuiz(Quiz qz) {
		if(adminDao.addQuiz(qz)>0) {
			return "Quiz Created Successfully";
		}
		else {
			return "Question didnt created";
		}
	}
	
	public Question findQuestionById(int qid) {
		return adminDao.getQestionDetails(qid);
	}
	
	public List<Score> getstandingPosition(){
		return adminDao.getstandingPosition();
	}
	
}
