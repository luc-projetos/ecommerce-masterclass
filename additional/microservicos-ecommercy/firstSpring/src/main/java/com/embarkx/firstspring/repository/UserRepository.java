package com.embarkx.firstspring.repository;

import com.embarkx.firstspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
