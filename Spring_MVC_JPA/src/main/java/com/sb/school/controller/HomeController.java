package com.sb.school.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sb.school.domain.Classes;
import com.sb.school.domain.QClasses;
import com.sb.school.domain.QUser;
import com.sb.school.domain.User;
import com.sb.school.repository.UserRepository;
import com.sb.school.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	@PersistenceContext
	private EntityManager em;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
						/* QueryDSL */
//		  JPAQuery<EntityManager> query = new JPAQuery<>(em);
		  JPAQueryFactory queryFactory = new JPAQueryFactory(em);

//		  QUser user = new QUser("u");
		  QUser user = QUser.user;

		  User foundUser = (User) queryFactory
//				  .selectFrom(qUser) // select + from
				  .from(user)
				  .where(user.username.eq("sb"))
				  .orderBy(user.username.desc())
				  .fetchOne();
		  
		  log.debug("foundUser {}", foundUser.toString());
		  
		  				/* Spring-Data */
		  List<User> foundUsers = userRepository.findByPassword("1234");
		  log.debug("foundByPassword {}", foundUsers.toString());
		  
		  Classes cl = em.find(Classes.class, "0001");
		  List<User> foundUsers2 = userRepository.findByClassCode(cl);
		  log.debug("foundByClass {}", foundUsers2.toString());
		  
		  User foundUser3 = userRepository.findOneByName("유상백");
		  log.debug("foundOneByName {}", foundUser3.toString());
		  
		  					/* JPQL */
//		  Query query1 = em.createQuery("select u from User u where u.username = :username", User.class); 
//		  query1.setParameter("username", "sb"); // 선택이 아닌 필수
//		  System.out.println("result1 : " + query1.getSingleResult());

//		  Query query2 = em.createQuery("select u from User u", User.class);
//		  System.out.println("result2 : " + query2.getResultList());

		model.addAttribute("LIST", userService.getList());
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(User user, String className) {
		
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
		
		QClasses classes = QClasses.classes;
		
		Classes cl = queryFactory
				.selectFrom(classes)
				.where(classes.subject.eq(className))
				.fetchOne();
		
		log.debug("fetchedClasses {}", cl);
		
		user.setClassCode(cl);
		
		try {		
			userService.join(user);
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("이미 존재하는 회원입니다");
		}
		
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String username) {
		userService.deleteUser(username);
		return "redirect:/";
	}

}
