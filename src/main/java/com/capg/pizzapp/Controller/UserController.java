package com.capg.pizzapp.Controller;

import com.capg.pizzapp.Entity.User;
import com.capg.pizzapp.Form.Forms;
import com.capg.pizzapp.Service.UserService;
import com.capg.pizzapp.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user").toUriString());
        return ResponseEntity.created(uri).body(userService.createUser(user));
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getUser() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") int userId) {
        return ResponseEntity.ok().body(userService.getUser(userId));
    }

//    Update User
    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable("userId") int userId, @RequestBody Forms.UpdateUserForm form) {
        userService.updateUser(userId, form.getUserName(), form.getUserAddress(), form.getUserPhoneNumber());
        return ResponseEntity.ok().body("User " + userId + " updated.");
    }

//    Delete User with userId
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().body("User deleted with userId: " + userId);
    }
}
