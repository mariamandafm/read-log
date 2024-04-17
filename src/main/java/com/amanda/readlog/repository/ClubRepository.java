package com.amanda.readlog.repository;

import com.amanda.readlog.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
