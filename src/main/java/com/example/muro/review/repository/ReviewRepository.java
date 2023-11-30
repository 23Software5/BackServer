// ReviewRepository.java
package com.example.muro.review.repository;

import com.example.muro.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE r.user.id = :userId")
    List<Review> findAllByUserId(Long userId);
}
