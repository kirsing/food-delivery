package com.kirsing.userinfo.mapper;

import com.kirsing.userinfo.dto.UserDTO;
import com.kirsing.userinfo.entity.UserInfo;

public class UserInfoMapper {
    public static UserDTO mapToUserDto(UserInfo userInfo, UserDTO userDTO) {
        userDTO.setUserId(userInfo.getUserId());
        userDTO.setUsername(userInfo.getUsername());
        userDTO.setUserPassword(userInfo.getUserPassword());
        userDTO.setAddress(userInfo.getAddress());
        userDTO.setCity(userInfo.getCity());
        return userDTO;
    }

    public static UserInfo mapToUser(UserDTO userDTO, UserInfo userInfo) {
        userInfo.setUserId(userInfo.getUserId());
        userInfo.setUsername(userDTO.getUsername());
       userInfo.setUserPassword(userDTO.getUserPassword());
        userInfo.setAddress(userDTO.getAddress());
        userInfo.setCity(userDTO.getCity());
        return userInfo;
    }
}
