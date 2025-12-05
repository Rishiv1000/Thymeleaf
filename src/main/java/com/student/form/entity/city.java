package com.student.form.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class city {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private state state;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private country country;
}
