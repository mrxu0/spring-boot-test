package springboot.demo.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import springboot.demo.test.entity.Order;
import springboot.demo.test.entity.User;

import java.util.List;

@Component
public interface OrderMapper extends BaseMapper<Order> { }

