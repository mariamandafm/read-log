package com.amanda.readlog.dto;

import com.amanda.readlog.model.Club;
import com.amanda.readlog.model.User;
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
    private User creator;
    private String name;
    private String description;
    private Date creation_date;
    private Set<User> members;
    private Set<Club.Tag> tags;
}