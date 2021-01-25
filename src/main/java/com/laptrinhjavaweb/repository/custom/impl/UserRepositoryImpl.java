package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntity findById(long id) {
        StringBuilder sql = new StringBuilder("FROM UserEntity u");
        sql.append(" WHERE u.id = " + id + "");
        Query query = entityManager.createQuery(sql.toString());
        return (UserEntity) query.getSingleResult();
    }

    @Override
    public void deleteByUserr(long id) {
        StringBuilder sql = new StringBuilder("delete from user where id = "+ id);
        Query query = entityManager.createQuery(sql.toString());
        query.executeUpdate();
    }

}
