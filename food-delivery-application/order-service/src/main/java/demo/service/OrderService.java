package demo.service;


import demo.model.Address;
import demo.model.Order;



public interface OrderService {

    void processOrderInfo(
            String id,
            Order order,
            boolean exportOrderToKml,
            boolean sendOrderToPaymentService
    );
}
