package com.example.jpaexample.service;

import com.example.jpaexample.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
@Transactional
public class UserDaoService {
    @PersistenceContext
    EntityManager entityManager;

    public long insert(User user){
        entityManager.persist(user);
        return user.getId();
    }
}
