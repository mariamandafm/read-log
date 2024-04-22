package com.amanda.readlog.controller;

import com.amanda.readlog.dto.ClubDto;
import com.amanda.readlog.dto.ReadingDto;
import com.amanda.readlog.mappers.Mapper;
import com.amanda.readlog.model.Club;
import com.amanda.readlog.model.Reading;
import com.amanda.readlog.service.ClubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private ClubService clubService;
    private Mapper<Club, ClubDto> clubMapper;
    private Mapper<Reading, ReadingDto> readingMapper;

    public ClubController(ClubService clubService, Mapper<Club, ClubDto> clubMapper, Mapper<Reading, ReadingDto> readingMapper) {
        this.clubService = clubService;
        this.clubMapper = clubMapper;
        this.readingMapper = readingMapper;
    }

    @PostMapping
    public ResponseEntity<ClubDto> createClub(@RequestBody ClubDto club) {
        Club clubEntity = clubMapper.mapFrom(club);
        Club savedClubEntity = clubService.save(clubEntity);
        ClubDto savedClubDto = clubMapper.mapTo(savedClubEntity);

        return new ResponseEntity<>(savedClubDto, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClubDto> getClub(@PathVariable("id") Long id) {
        Optional<Club> foundClub = clubService.findOne(id);
        return foundClub.map(club -> {
            ClubDto clubDto = clubMapper.mapTo(club);
            return new ResponseEntity<>(clubDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/{clubId}/members/{userId}")
    public ResponseEntity<String> addMemberToClub(@PathVariable("clubId") Long clubId, @PathVariable("userId") Long userId) {
        clubService.addMemberToClub(clubId, userId);
        return new ResponseEntity<String>("User added to club.", HttpStatus.OK);
    }

    @PostMapping(path = "{clubId}/reading")
    public ResponseEntity<String> addCurrentReading(@PathVariable Long clubId, @RequestBody ReadingDto reading){
        Reading readingEntity = readingMapper.mapFrom(reading);
        clubService.addCurrentReading(clubId, readingEntity);

        return new ResponseEntity<String>("Reading added successfully", HttpStatus.OK);
    }

    @GetMapping(path = "/{clubId}/previous-readings")
    public ResponseEntity<List<ReadingDto>> getPreviousReadings(@PathVariable Long clubId){
        List<Reading> previousReadings = clubService.getPreviousReadings(clubId);
        List<ReadingDto> previousReadingsDto = previousReadings.stream()
                .map(reading -> readingMapper.mapTo(reading))
                .toList();

        return new ResponseEntity<List<ReadingDto>>(previousReadingsDto, HttpStatus.OK);
    }
}
