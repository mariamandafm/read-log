package com.amanda.readlog.service;

import com.amanda.readlog.model.Club;
import com.amanda.readlog.repository.ClubRepository;
import org.springframework.stereotype.Service;

@Service
public class ClubServiceImpl implements ClubService{

    private final ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public Club save(Club club) {
        return clubRepository.save(club);
    }
}
