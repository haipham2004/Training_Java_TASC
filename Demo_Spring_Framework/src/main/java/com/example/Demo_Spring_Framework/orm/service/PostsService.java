package com.example.Demo_Spring_Framework.orm.service;

import com.example.Demo_Spring_Framework.orm.dto.PostsDTO;
import com.example.Demo_Spring_Framework.orm.entiy.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostsService {

    List<PostsDTO> getAll();

    PostsDTO getOne(Integer id);

    public Page<PostsDTO> getAllPagePost(Pageable pageable);

    List<PostsDTO> search(Integer id);
}
