package com.example.Demo_Spring_Framework.orm.repository;

import com.example.Demo_Spring_Framework.orm.entiy.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

}
