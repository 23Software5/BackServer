// ReviewRepository.java
package com.example.muro.review.repository;

import com.example.muro.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
