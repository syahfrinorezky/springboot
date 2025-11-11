package com.example.springboot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springboot.Model.Users;

public interface UserRepo extends JpaRepository<Users, Long> {

}
