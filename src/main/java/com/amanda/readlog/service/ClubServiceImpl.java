package com.amanda.readlog.service;

import com.amanda.readlog.exception.BookNotFoundException;
import com.amanda.readlog.exception.ClubNotFoundException;
import com.amanda.readlog.exception.UserNotFoundException;
import com.amanda.readlog.model.Club;
import com.amanda.readlog.model.Reading;
import com.amanda.readlog.model.User;
import com.amanda.readlog.repository.ClubRepository;
import com.amanda.readlog.repository.ReadingRepository;
import com.amanda.readlog.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ClubServiceImpl implements ClubService{

    private final ClubRepository clubRepository;

    private final UserRepository userRepository;

    private final ReadingRepository readingRepository;

    public ClubServiceImpl(ClubRepository clubRepository, UserRepository userRepository, ReadingRepository readingRepository) {
        this.clubRepository = clubRepository;
        this.userRepository = userRepository;
        this.readingRepository = readingRepository;
    }

    @Override
    public Club save(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public Optional<Club> findOne(Long id) {
        return Optional.ofNullable(clubRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book does not exists")));
    }

    @Override
    @Transactional
    public void addMemberToClub(Long clubId, Long userId) {
        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new ClubNotFoundException("Club not found with id: "+clubId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User nor found with id: "+userId));

        if (club.getMembers().contains(user)) {
            throw new IllegalArgumentException("User is already a member of the club.");
        }

        club.getMembers().add(user);
        user.getClubs().add(club);

        clubRepository.save(club);
        userRepository.save(user);
    }

    @Override
    public void addCurrentReading(Long clubId, Reading readingEntity) {
        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new ClubNotFoundException("Club not found with id: "+clubId));

        club.setCurrentReading(readingEntity);

        clubRepository.save(club);
    }
}
