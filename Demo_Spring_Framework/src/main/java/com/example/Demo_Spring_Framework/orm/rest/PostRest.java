package com.example.Demo_Spring_Framework.orm.rest;

import com.example.Demo_Spring_Framework.orm.dto.PostsDTO;
import com.example.Demo_Spring_Framework.orm.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostRest {

    private PostsService postsService;

    @Autowired
    public PostRest(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("hien-thi")
    public ResponseEntity<List<PostsDTO>> getAll() {
        return ResponseEntity.ok(postsService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<PostsDTO> getOne(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(postsService.getOne(id));
    }

    @GetMapping("/page")
    public Page<PostsDTO> getAllPosts(@RequestParam(defaultValue = "0") int pageNo,
                                      @RequestParam(defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return postsService.getAllPagePost(pageable);
    }

    @GetMapping("search")
    public ResponseEntity<List<PostsDTO>> search(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(postsService.search(id));
    }
}
