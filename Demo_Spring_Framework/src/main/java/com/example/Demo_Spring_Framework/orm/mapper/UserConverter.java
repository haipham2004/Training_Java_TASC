package com.example.Demo_Spring_Framework.orm.mapper;

import com.example.Demo_Spring_Framework.orm.dto.UsersDTO;
import com.example.Demo_Spring_Framework.orm.entiy.Users;

public class UserConverter {

    public static Users convertDtoToEntity(UsersDTO usersDTO){

        return new Users(usersDTO.getId() ,usersDTO.getName());
    }

    public static UsersDTO convertEntiyToDto(Users users){

        return new UsersDTO(users.getId() ,users.getName());
    }
}
