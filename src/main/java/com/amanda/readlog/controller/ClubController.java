package com.amanda.readlog.controller;

import com.amanda.readlog.dto.ClubDto;
import com.amanda.readlog.mappers.Mapper;
import com.amanda.readlog.model.Club;
import com.amanda.readlog.service.ClubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private ClubService clubService;
    private Mapper<Club, ClubDto> clubMapper;

    public ClubController(ClubService clubService, Mapper<Club, ClubDto> clubMapper) {
        this.clubService = clubService;
        this.clubMapper = clubMapper;
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
}
