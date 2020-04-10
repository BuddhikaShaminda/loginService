package com.jwt.loginservice.repository;

import com.jwt.loginservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{

    User findByUsername(String userName);
}
