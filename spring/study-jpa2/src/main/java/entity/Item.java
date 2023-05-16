package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private Integer price;
    private Integer stockQuantity;
}
