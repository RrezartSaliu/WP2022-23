package mk.finki.ukim.mk.lab.repository;


import lombok.Data;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class OrderRepository {
    int totalOrders;
    List<Order> orderList;

    public OrderRepository(){
        totalOrders=0;
        orderList = new ArrayList<>();
    }
    public void addOrder(){
        totalOrders+=1;
    }
    public Order placeOrder(String balloonColor,String balloonSize, String clientName, String address){
        return new Order(balloonColor, balloonSize, clientName, address);
    }
}
