package com.example.touristhomestayplatform.repository;

import com.example.touristhomestayplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom query methods can be defined here if needed
}
