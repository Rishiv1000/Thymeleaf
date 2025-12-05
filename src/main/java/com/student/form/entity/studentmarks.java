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
public class studentmarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentmarksId;
    private String student_class;
    private String college;
    private Long obtaining;
    private Long obtained;

    @ManyToOne
    @JoinColumn(name= "student_id")
    private student student;
}
