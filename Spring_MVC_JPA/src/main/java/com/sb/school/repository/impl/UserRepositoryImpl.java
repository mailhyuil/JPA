package com.sb.school.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class UserRepositoryImpl{
	
    @PersistenceContext
    EntityManager em;

}
