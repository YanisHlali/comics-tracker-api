
package com.comicstracker.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Period {

    @Id
    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    @JsonProperty("start_year")
    private int startYear;

    @Column(nullable = false)
    @JsonProperty("end_year")
    private int endYear;
}
