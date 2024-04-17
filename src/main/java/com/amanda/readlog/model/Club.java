package com.amanda.readlog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clubs")
public class Club {

    public enum Tag {
        FICTION,
        NON_FICTION,
        HORROR,
        BIOGRAPHY,
        ROMANCE,
        POETRY,
        SUSPENSE,
        FANTASY,
        SCIENCE_FICTION,
        THRILLER,
        DYSTOPIAN,
        HUMOR,
        TRUE_CRIME,
        SELF_HELP
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    private String name;
    private String description;
    private Date creation_date;

    @ManyToMany
    @JoinTable(
            name = "club_members",
            joinColumns = @JoinColumn(name = "club_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> members;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "club_tags", joinColumns = @JoinColumn(name = "club_id"))
    @Column(name = "tag", nullable = false)
    private Set<Tag> tags;
}
