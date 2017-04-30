package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static demo.model.OrderStatus.ORDERING;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    private String id;
    private List<OrderItem> items;
    private Double total;
    private String note;
    private Address address;
    private Time timestamp;
    private OrderStatus status;

    public Order(){
        this.total=0.0;
        this.items = new ArrayList<>();
        status = ORDERING;
        this.note = null;
        this.address = null;
    }
}
