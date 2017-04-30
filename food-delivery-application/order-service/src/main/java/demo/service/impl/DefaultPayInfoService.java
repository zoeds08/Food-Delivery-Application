package demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.model.Order;
import demo.model.OrderStatus;
import demo.service.PayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultPayInfoService implements PayInfoService {

    @Autowired
    private ObjectMapper objectMapper;

    public DefaultPayInfoService(){
        super();
    }

    @Override
    public void persist(Order order) {
        objectMapper.
    }

    @Override
    public Order findById(String id) {
        return null;
    }

    @Override
    public void updateStatusById(String id, OrderStatus status) {

    }
}
