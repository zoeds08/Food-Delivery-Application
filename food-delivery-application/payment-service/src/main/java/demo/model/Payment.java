package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment {

    private Long id;
    private String number;
    private String expDate;
    private Integer secureCode;
    private Date timestamp = new Date();

    public Payment(){}
}
