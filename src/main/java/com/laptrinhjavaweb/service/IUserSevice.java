package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserSevice {
    void deleteByUserr(long userid);
    void insertUser(UserEntity userEntity);
    int totalitem();
    List<UserDTO> findAll(Pageable pageable);
}
