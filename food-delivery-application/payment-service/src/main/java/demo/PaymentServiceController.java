package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Source;

@EnableBinding(Source.class)
@RestController
public class PaymentServiceController {

    @Autowired
    private MessageChannel output;

    @RequestMapping(path = "/api/order",method = RequestMethod.POST)
    public void order(@RequestBody String orderInfo){
        this.output.send(MessageBuilder.withPayload(orderInfo).build());
    }
}
