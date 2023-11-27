package com.capg.pizzapp.ServiceImpl;

import com.capg.pizzapp.Entity.User;
import com.capg.pizzapp.Repository.UserRepository;
import com.capg.pizzapp.Service.UserService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @Slf4j @Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user){
        log.info("Creating user...");
        return userRepository.save(user);
    }

    @Override
    public User getUser(int userId) {
        Optional<User> userByUserId = Optional.ofNullable(userRepository.findUserByUserId(userId));
        if(!userByUserId.isPresent()){
            log.error("User not found.");
            throw new IllegalStateException("User with userId " + userId + " not found.");
        }
        else{
            log.info("User {} Found.", userId);
            return userByUserId.get();
        }
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users...");
        return userRepository.findAll();
    }

    @Transactional @Override
    public void updateUser(int userId, String userName, String userAddress, String userPhoneNumber) {
        Optional<User> userByUserId = Optional.ofNullable(userRepository.findUserByUserId(userId));
        if(!userByUserId.isPresent()){
            log.info("User Not Found!");
            throw new IllegalStateException("User with userId " + userId + " not found.");
        } else{
            log.info("Updating user {}...", userId);
            User user = userRepository.findUserByUserId(userId);
            user.setUserName(userName);
            user.setUserAddress(userAddress);
            user.setUserPhoneNumber(userPhoneNumber);
        }
    }

    @Override
    public void deleteUser(int userId) {
        Optional<User> userByUserId = Optional.ofNullable(userRepository.findUserByUserId(userId));
        if(!userByUserId.isPresent()){
            log.error("User not Found.");
            throw new IllegalStateException("User with userId " + userId + " not found.");
        } else{
            log.info("Deleting user {}...", userId);
            User user = userRepository.findUserByUserId(userId);
            userRepository.delete(user);
        }
    }
}