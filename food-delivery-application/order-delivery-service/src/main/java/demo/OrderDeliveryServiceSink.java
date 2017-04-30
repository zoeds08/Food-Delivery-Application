package demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.sql.Time;
import java.util.Random;

@MessageEndpoint
@EnableBinding(Sink.class)
@Slf4j
public class OrderDeliveryServiceSink {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private ObjectMapper objectMapper;

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void orderDelivery(String input) throws Exception{
        log.info("Order input in delivery: " + input);
        Order payload = this.objectMapper.readValue(input,Order.class);
        payload.setEstimateDelivery(generateEstimateTime());
        this.template.convertAndSend("/topic/order",payload);
    }

    private Time generateEstimateTime(){
        Random rd = new Random();
        int num = rd.nextInt(56) + 1;
        return new Time(num);
    }
}
