package io.spring.practice1.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime registerDate;

    @OneToOne(mappedBy = "profile")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;
}
