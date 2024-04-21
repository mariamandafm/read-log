package com.amanda.readlog.mappers;

import com.amanda.readlog.dto.ClubDto;
import com.amanda.readlog.dto.UserDto;
import com.amanda.readlog.model.Club;
import com.amanda.readlog.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;

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
        modelMapper.createTypeMap(UserDto.class, User.class);

        Club club = modelMapper.map(clubDto, Club.class);

        club.setMembers(new HashSet<>());
        for (UserDto userDto : clubDto.getMembers()) {
            User user = modelMapper.map(userDto, User.class);
            club.getMembers().add(user);
        }

        return club;
    }
}
