package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Admin;
import com.bean.Question;
import com.bean.Quiz;
import com.bean.Score;


@Repository
public class AdminDao {

	@Autowired
	EntityManagerFactory emf;
	
	public Admin getAdminDetails(String email) {
		EntityManager manager = emf.createEntityManager();		
		Admin ad = manager.find(Admin.class, email);		
		return ad;
	}
	
	public Question getQestionDetails(int qid) {
		EntityManager manager = emf.createEntityManager();		
		Question qn = manager.find(Question.class, qid);		
		return qn;
	}
	
	public int checkAdmin(Admin ad) {
		
			EntityManager manager = emf.createEntityManager();
			Admin a = manager.find(Admin.class, ad.getEmail());
			if(a==null) {
				return 0;
			}
			else {
				String pass=ad.getPassword();
				if(pass.equals(a.getPassword())) {
				return 1;
				}
				return 0;
			}
		
	}
	
	public int updatePassword(Admin ad) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		Admin e = manager.find(Admin.class, ad.getEmail());
		if(e==null) {
			return 0;
		}
		else {
			e.setPassword(ad.getPassword());
			tran.begin();
			manager.merge(e);
			tran.commit();
			return 1;
		}
	}
	
	public int addQuestion(Question qn) {
		try {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
			manager.persist(qn);
			tran.commit();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return 0;
		}
	}
	
	public int addQuiz(Quiz qz) {
		try {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
			manager.persist(qz);
			tran.commit();
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return 0;
		}
	}
	
	public List<Score> getstandingPosition(){
		EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select s.email,s.subject,s.score FROM Score s ORDER BY s.score DESC");//JPQL
		List<Score> list = qry.getResultList();
		return list;
	}
}
