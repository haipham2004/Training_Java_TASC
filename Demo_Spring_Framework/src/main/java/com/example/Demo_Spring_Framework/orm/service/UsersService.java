package com.example.Demo_Spring_Framework.orm.service;

import com.example.Demo_Spring_Framework.orm.dto.UsersDTO;

import java.util.List;

public interface UsersService {

    List<UsersDTO> getAll();

    UsersDTO getOne(Integer id);
}
