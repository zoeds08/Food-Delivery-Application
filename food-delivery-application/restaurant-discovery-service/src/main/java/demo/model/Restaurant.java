package demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Document
public class Restaurant {

    @Id
    private String id;
    private String restaurantName;
    private String address;

    @JsonCreator
    public Restaurant(@JsonProperty("restaurantName") String restaurantName){}

}
