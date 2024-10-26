package com.ssk.track_it.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssk.track_it.models.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    
}
