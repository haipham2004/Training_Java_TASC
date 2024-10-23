package com.example.Demo_Spring_Framework.orm.rest;

import com.example.Demo_Spring_Framework.orm.dto.PostsDTO;
import com.example.Demo_Spring_Framework.orm.dto.UsersDTO;
import com.example.Demo_Spring_Framework.orm.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserRest {

    private UsersService usersService;

    @Autowired
    public UserRest(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("hien-thi")
    public ResponseEntity<List<UsersDTO>> getAll() {
        return ResponseEntity.ok(usersService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<UsersDTO> getOne(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(usersService.getOne(id));
    }
}
