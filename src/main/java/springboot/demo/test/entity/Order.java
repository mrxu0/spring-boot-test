package springboot.demo.test.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单id")
    private Long id;
    @ApiModelProperty("订单内容")
    private String content;
}
