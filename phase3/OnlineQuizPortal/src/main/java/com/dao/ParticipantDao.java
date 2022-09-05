package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Admin;
import com.bean.Participant;
import com.bean.Question;
import com.bean.Quiz;
import com.bean.Score;
import com.bean.Userquiz;

@Repository
public class ParticipantDao {

	@Autowired
	EntityManagerFactory emf;
	
	public int userRegister(Participant pt) {
		try {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
			manager.persist(pt);
			tran.commit();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return 0;
		}
	}
	
	public int checkUser(Participant pt) {
		EntityManager manager = emf.createEntityManager();
		Participant p = manager.find(Participant.class, pt.getEmail());
		if(p==null) {
			return 0;		
		}
		else {
			
			String pass=pt.getPassword();
			if(pass.equals(p.getPassword())) {
			return 1;
			}
			return 0;
		}
	
}
	
	public int takeQuiz(Userquiz uq) {
		try {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
			manager.persist(uq);
			Score s = manager.find(Score.class, uq.getEmail());
			Question q = manager.find(Question.class, uq.getQid());
			Quiz qz = manager.find(Quiz.class, uq.getQzid());
			String res = uq.getUsercorrectans();
			if(res.equals(q.getCorrectanswer())) {
				s.setEmail(uq.getEmail());
				s.setSubject(qz.getSubject());
				s.setScore(s.getScore()+1);
			}
			tran.commit();
			return 1;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return 0;
		}
	}
	
	public Score getResult(String email) {
		EntityManager manager = emf.createEntityManager();		
		Score s = manager.find(Score.class, email);		
		return s;
	}
	
	public List<Quiz> getAllQuiz(){
		EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select q from Quiz q");//JPQL
		List<Quiz> list = qry.getResultList();
		return list;
	}
}
