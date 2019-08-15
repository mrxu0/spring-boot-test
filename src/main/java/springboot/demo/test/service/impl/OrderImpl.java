package springboot.demo.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.demo.test.entity.Order;
import springboot.demo.test.entity.User;
import springboot.demo.test.mapper.OrderMapper;
import springboot.demo.test.mapper.UserMapper;
import springboot.demo.test.service.OrderService;
import springboot.demo.test.service.UserService;
import springboot.demo.utils.RandomString;

import java.util.List;

@Service
public class OrderImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> getAll() {
        return orderMapper.getAll();
    }
}
