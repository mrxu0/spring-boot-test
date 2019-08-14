package springboot.demo.test.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Shop implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double price;
    private String des;
}
