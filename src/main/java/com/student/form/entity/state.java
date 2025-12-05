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
public class state {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;
    private String stateName;

}
