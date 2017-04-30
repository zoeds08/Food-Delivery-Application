package demo.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.model.Address;
import demo.model.Order;
import demo.model.OrderItem;
import demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class DefaultOrderServiceImpl implements OrderService{

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultOrderServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    public DefaultOrderServiceImpl(){
        super();
    }

    @HystrixCommand(fallbackMethod = "processOrderInfoFallback")
    @Override
    public void processOrderInfo(String id, Order order, boolean exportOrderToKml, boolean sendOrderToPaymentService) {
        String paymentService = "http://payment-service";
        if(sendOrderToPaymentService){
            log.info("Order building is calling payment REST API");
            this.restTemplate.postForLocation(paymentService + "/api/order",order);
        }
    }

    public void processOrderInfoFallback(String id, Order order, boolean exportOrderToKml, boolean sendOrderToPaymentService){
        LOGGER.error("Hystrix Fallback Method. Unable to send message for payment");
    }
}
