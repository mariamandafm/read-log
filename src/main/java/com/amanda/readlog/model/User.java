package com.amanda.readlog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String username;
    private String email;
    private String password;

    @ManyToMany(mappedBy = "members")
    private Set<Club> clubs;

    @OneToMany(mappedBy = "creator")
    private Set<Club> clubs_created;
}
