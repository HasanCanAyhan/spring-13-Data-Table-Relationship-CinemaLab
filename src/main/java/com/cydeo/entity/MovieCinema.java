package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema extends BaseEntity{

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    //It should be foreign key in many-side : here many side is MovieCinema
    //MovieCinema - Movie (ManyToOne)
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    //MovieCinema - Cinema (ManyToOne)
    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;


}
