package io.spring.practice1.entity;

import io.spring.practice1.statics.UserGrade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private UserGrade grade;

    @OneToMany(mappedBy = "grade")
    private List<Profile> profiles;
}
