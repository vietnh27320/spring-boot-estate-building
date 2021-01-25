package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.UserEntity;

public interface UserRepositoryCustom {
    UserEntity findById(long id);
    void deleteByUserr(long id);
}
