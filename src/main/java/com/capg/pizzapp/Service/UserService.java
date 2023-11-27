package com.capg.pizzapp.Service;

import com.capg.pizzapp.Entity.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public User getUser(int userId);
    public List<User> getUsers();
    public void updateUser(int userId, String userName, String userAddress, String userPhoneNumber);
    public void deleteUser(int userId);
}
