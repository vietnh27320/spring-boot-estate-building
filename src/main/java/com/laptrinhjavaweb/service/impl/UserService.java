package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserSevice {


    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public void deleteByUserr(long userid) {
        userRepository.deleteByUserr(userid);
    }

    @Override
    public void insertUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public int totalitem() {
        return (int) userRepository.count();
    }

    @Override
    public List<UserDTO> findAll(Pageable pageable) {
        List<UserDTO> results = new ArrayList<>();
        List<UserEntity> userEntities = userRepository.findAll(pageable).getContent();
        for(UserEntity userEntity: userEntities){
            UserDTO userDTO = new UserConverter().convertToDto(userEntity);
            results.add(userDTO);
        }
        return results;
    }


}


