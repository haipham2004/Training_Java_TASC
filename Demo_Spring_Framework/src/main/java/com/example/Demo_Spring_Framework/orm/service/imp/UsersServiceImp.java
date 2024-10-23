package com.example.Demo_Spring_Framework.orm.service.imp;

import com.example.Demo_Spring_Framework.RestController_Controller.exception.ResourceNotFoundException;
import com.example.Demo_Spring_Framework.orm.dto.PostsDTO;
import com.example.Demo_Spring_Framework.orm.dto.UsersDTO;
import com.example.Demo_Spring_Framework.orm.mapper.UserConverter;
import com.example.Demo_Spring_Framework.orm.repository.UsersRepository;
import com.example.Demo_Spring_Framework.orm.service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImp implements UsersService {

    private UsersRepository usersRepository;

    private ModelMapper modelMapper;

    @Autowired
    public UsersServiceImp(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UsersDTO> getAll() {
        return usersRepository.findAll().stream()
                .map((user) -> UserConverter.convertEntiyToDto(user)).collect(Collectors.toList());
    }

    @Override
    public UsersDTO getOne(Integer id) {
        return modelMapper
                .map(usersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tồn tại User có id: "+id)), UsersDTO.class);
    }
}
