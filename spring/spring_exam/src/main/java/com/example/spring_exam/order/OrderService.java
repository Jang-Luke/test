package com.example.spring_exam.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
