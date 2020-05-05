package ru.itis.semestrovaya.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "entry")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String text;

    @ManyToOne
    @JoinColumn
    private User author;

    private LocalDate date;
    private String location;

    @Enumerated(value = EnumType.STRING)
    private IsPublic isPublic;

    @ManyToMany
    private List<Tag> tags;

    private String filename;

    @ManyToMany(mappedBy = "likedEntries")
    private List<User> likes;

    @Transient
    private Long priority;
}
