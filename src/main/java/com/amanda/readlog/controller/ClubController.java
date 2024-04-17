package com.amanda.readlog.controller;

import com.amanda.readlog.dto.ClubDto;
import com.amanda.readlog.mappers.Mapper;
import com.amanda.readlog.model.Club;
import com.amanda.readlog.service.ClubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
