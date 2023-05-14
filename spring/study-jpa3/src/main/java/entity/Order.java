package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
@Getter
@Setter
public class Order {
    @Id @GeneratedValue
    @Column(name = "orders_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    private LocalDate orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();
}
