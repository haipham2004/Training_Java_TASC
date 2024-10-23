package com.example.Demo_Spring_Framework.orm.service.imp;

import com.example.Demo_Spring_Framework.RestController_Controller.exception.ResourceNotFoundException;
import com.example.Demo_Spring_Framework.orm.dto.PostsDTO;
import com.example.Demo_Spring_Framework.orm.exception.ResourceNotFoundExceptions;
import com.example.Demo_Spring_Framework.orm.repository.PostsRepository;
import com.example.Demo_Spring_Framework.orm.service.PostsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsServiceImp implements PostsService {

    private PostsRepository postsRepository;

    private ModelMapper modelMapper;

    @Autowired
    public PostsServiceImp(PostsRepository postsRepository, ModelMapper modelMapper) {
        this.postsRepository = postsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PostsDTO> getAll() {
        return postsRepository.getAllJoinFetch().stream()
                .map((post) -> modelMapper.map(post,PostsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PostsDTO getOne(Integer id) {
        return modelMapper
                .map(postsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("Không tồn tại Post có id: "+id)),PostsDTO.class);
    }

    @Override
    public Page<PostsDTO> getAllPagePost(Pageable pageable) {
        return postsRepository.getAllJoinFetchPage(pageable)
                .map((post) -> modelMapper.map(post,PostsDTO.class));
    }

    @Override
    public List<PostsDTO> search(Integer id) {
        return postsRepository.search(id);
    }
}
