package com.amanda.readlog.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
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

    @ManyToMany(mappedBy = "members", fetch = FetchType.LAZY)
    private Set<Club> clubs = new HashSet<>();

    @OneToMany(mappedBy = "creator")
    private Set<Club> clubs_created;
}
