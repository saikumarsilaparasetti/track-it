package com.ssk.track_it.services;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssk.track_it.models.User;
import com.ssk.track_it.repo.UserRepo;



@Service
public class UserService {
    // private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepo repo;

   
    // @Autowired
    // public UserService(BCryptPasswordEncoder passwordEncoder) {
    //     this.passwordEncoder = passwordEncoder;
    // }

    public User createUser(User user) {
        // String encodedPassword = passwordEncoder.encode(user.getPassword());
        // user.setPassword(encodedPassword);
        // repo.save(user);
        return user;
    }
}
