package com.amanda.readlog.dto;

import com.amanda.readlog.model.Club;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClubDto {
    private Integer id;
    private UserDto creator;
    private String name;
    private String description;
    private Date creation_date;
    private ReadingDto currentReading;
    private Set<UserDto> members;
    private Set<Club.Tag> tags;
}