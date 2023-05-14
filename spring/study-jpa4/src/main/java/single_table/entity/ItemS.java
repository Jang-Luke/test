package single_table.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn // single_table 전략에서는 생략해도 DTYPE column 이 자동 생성됨
@Getter
@Setter
public abstract class ItemS {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String name;
    private Integer price;
}
