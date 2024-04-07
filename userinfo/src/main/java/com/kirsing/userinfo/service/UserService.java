package com.kirsing.userinfo.service;


import com.kirsing.userinfo.dto.UserDTO;
import com.kirsing.userinfo.entity.UserInfo;
import com.kirsing.userinfo.mapper.UserInfoMapper;
import com.kirsing.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserDTO addUser(UserDTO userDTO) {
        UserInfo savedUser = userRepository.save(UserInfoMapper.mapToUser(userDTO, new UserInfo()));
        return UserInfoMapper.mapToUserDto(savedUser, new UserDTO());
    }

    public ResponseEntity<UserDTO> fetchUserById(Long userId) {
        Optional<UserInfo> fetchedUser = userRepository.findById(userId);
        if (fetchedUser.isPresent()) {
            return new ResponseEntity<>(UserInfoMapper.mapToUserDto(fetchedUser.get(), new UserDTO()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
