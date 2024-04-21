package com.amanda.readlog.repository;

import com.amanda.readlog.model.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingRepository extends JpaRepository<Reading, Long> {
}
