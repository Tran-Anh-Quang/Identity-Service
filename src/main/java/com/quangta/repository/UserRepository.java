package com.quangta.repository;

import java.util.Optional;

import com.quangta.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByPhoneNumber(String phoneNumber);

    Boolean existsByPhoneNumber(String phoneNumber);

    Boolean existsByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.password = ?2 WHERE u.email = ?1")
    void updatePassword(String email, String password);
}
