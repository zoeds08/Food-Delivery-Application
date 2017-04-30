package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItem {

    enum ProductType{
        PIZZA,DRINK,DESSERT;
    }

    private String itemId;
    private Integer quantity;
    private String itemDescription;
    private ProductType type;
    private Double unitPrice;

    public OrderItem(){}
}
