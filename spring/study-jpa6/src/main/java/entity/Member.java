package entity;

import entity.base.BaseAddress;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member extends BaseAddress {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}