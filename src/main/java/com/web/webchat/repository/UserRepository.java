package com.web.webchat.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.web.webchat.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

//    @Query("SELECT u FROM users u WHERE CONCAT(u.username, u.email) LIKE %?1%")
//    public List<User> search(String keyword);
}
