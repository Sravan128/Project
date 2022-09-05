package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Admin;
import com.bean.Participant;
import com.bean.Question;
import com.bean.Quiz;
import com.bean.Score;
import com.bean.Userquiz;
import com.dao.ParticipantDao;

@Service
public class ParticipantService {

	@Autowired
	ParticipantDao participantDao;
	
	public String userRegister(Participant pt) {
		if(participantDao.userRegister(pt)>0) {
			return "User Registration Successful";
		}
		else {
			return "User Registration Failure";
		}
	}
	
	public String checkUser(Participant pt) {
		if(participantDao.checkUser(pt)>0) {
			return "Participant Login Successful";
		}
		else {
			return "Failure! Provide Correct Credentials!";
		}
	}
	
	public String takeQuiz(Userquiz uq) {
		if(participantDao.takeQuiz(uq)>0) {
			return "Quiz Attempted Successfully";
		}
		else {
			return "Try Again!";
		}
	}
	
	public Score getResult(String email) {
		return participantDao.getResult(email);
	}
	
	public List<Quiz> getAllQuiz(){
		return participantDao.getAllQuiz();
	}
}
