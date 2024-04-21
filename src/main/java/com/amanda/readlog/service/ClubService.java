package com.amanda.readlog.service;

import com.amanda.readlog.model.Club;
import com.amanda.readlog.model.Reading;

import java.util.Optional;

public interface ClubService {
    Club save(Club club);

    Optional<Club> findOne(Long id);

    void addMemberToClub(Long clubId, Long userId);

    void addCurrentReading(Long clubId, Reading readingEntity);
}
