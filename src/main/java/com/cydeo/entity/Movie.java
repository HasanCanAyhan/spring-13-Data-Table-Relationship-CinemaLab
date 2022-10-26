package com.cydeo.entity;


import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Movie extends BaseEntity{

    private String name;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

    private Integer duration;

    @Column(columnDefinition = "text")// there is no limit if you put text
    private String summary;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel",
    joinColumns =@JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList; // third table bcs many to many

    //Why Set is better than List in @ManyToMany
    //List: 3 query statement: delete everything , insert again, find
    //set: 1 query statement : delete specific one

}
