package demo.rest;

import demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding
public class OrderServiceRestApi {

    @Autowired
    private MessageChannel output;

    @RequestMapping(path = "/api/order",method = RequestMethod.POST)
    public void transfer(@RequestBody Order order){
        this.output.send(MessageBuilder.withPayload(order).build());
    }
}
