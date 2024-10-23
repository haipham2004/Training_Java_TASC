package com.example.Demo_Spring_Framework.orm.repository;

import com.example.Demo_Spring_Framework.orm.dto.PostsDTO;
import com.example.Demo_Spring_Framework.orm.entiy.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Integer> {

    @Query("SELECT p FROM Posts p join fetch p.user")
    List<Posts> getAllJoinFetch();

    @Query("SELECT p FROM Posts p join fetch p.user")
    Page<Posts> getAllJoinFetchPage(Pageable pageable);

    @Query("SELECT new com.example.Demo_Spring_Framework.orm.dto.PostsDTO(p.title, p.content, p.user.name) FROM Posts p JOIN p.user WHERE p.id = :id")
    List<PostsDTO> search(@Param("id") Integer id);

}
