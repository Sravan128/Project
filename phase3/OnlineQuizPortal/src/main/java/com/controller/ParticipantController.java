package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Participant;
import com.bean.Question;
import com.bean.Quiz;
import com.bean.Score;
import com.bean.Userquiz;
import com.service.ParticipantService;

@RestController
@RequestMapping("participant")
public class ParticipantController {

	@Autowired
	ParticipantService participantService;
	
	@PostMapping(value = "userRegister",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String userRegister(@RequestBody Participant pt) {	
		return participantService.userRegister(pt);
	}
	
	@PostMapping(value = "signIn")
	public String checkUser(@RequestBody Participant pt) {
		return participantService.checkUser(pt);
	}
	
	@PostMapping(value = "takeQuiz",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String takeQuiz(@RequestBody Userquiz uq) {	
		return participantService.takeQuiz(uq);
	}
	
	@GetMapping(value = "getResult/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Score getResult(@PathVariable("email") String email) {
		return participantService.getResult(email);
	}
	
	@GetMapping(value = "getAllQuiz",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Quiz> getAllEmployeeInfoDB() {
		return participantService.getAllQuiz();
	}
}
