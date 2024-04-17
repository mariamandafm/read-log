package com.amanda.readlog.mappers;

import com.amanda.readlog.dto.ClubDto;
import com.amanda.readlog.model.Club;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClubMapperImpl implements Mapper<Club, ClubDto> {
    private final ModelMapper modelMapper;

    public ClubMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ClubDto mapTo(Club club) {
        return modelMapper.map(club, ClubDto.class);
    }

    @Override
    public Club mapFrom(ClubDto clubDto) {
        return modelMapper.map(clubDto, Club.class);
    }
}
