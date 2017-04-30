package demo.service;

import demo.model.Order;
import demo.model.OrderStatus;

/**
 * Created by vagrant on 4/30/17.
 */
public interface PayInfoService {

    void persist(Order order);
    Order findById(String id);
    void updateStatusById(String id, OrderStatus status);
}
