package com.sb.school.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sb.school.domain.QUser;
import com.sb.school.domain.User;
import com.sb.school.repository.UserRepository;
import com.sb.school.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;

	@PersistenceContext
	EntityManager em;

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

		  System.out.println("result : " + foundUser);
		  
		  log.debug("foundUser {}", foundUser.toString());
		  
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
	public String home(User user) {
		userService.join(user);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String username) {
		userService.deleteUser(username);
		return "redirect:/";
	}

}
