package com.sample_project.userApp.repository;

import com.sample_project.userApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
