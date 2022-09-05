package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Admin;
import com.bean.Question;
import com.bean.Quiz;
import com.bean.Score;
import com.service.AdminService;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping(value = "signIn")
	public String checkAdmin(@RequestBody Admin ad) {
		return adminService.CheckAdmin(ad);
	}	
	
	@PatchMapping(value = "updatePassword",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updatePassword(@RequestBody Admin ad) {
		return adminService.updatePassword(ad);
	}
	
	@PostMapping(value = "addQuestion",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addQuestion(@RequestBody Question qn) {	
		return adminService.addQuestion(qn);
	}
	
	@GetMapping(value = "questionbyID/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Question findQuestionById(@PathVariable("id") int qid) {
		return adminService.findQuestionById(qid);
	}
	
	@PostMapping(value = "addQuiz",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addQuiz(@RequestBody Quiz qz) {	
		return adminService.addQuiz(qz);
	}
	
	@GetMapping(value = "getStandingPosition",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Score> getstandingPosition() {
		return adminService.getstandingPosition();
	}
}
