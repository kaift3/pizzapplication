package com.capg.pizzapp.Repository;

import com.capg.pizzapp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUserId(int userId);
}
