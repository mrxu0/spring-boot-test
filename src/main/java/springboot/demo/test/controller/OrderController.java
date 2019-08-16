package springboot.demo.test.controller;

import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.demo.common.PageInfo;
import springboot.demo.common.resp.Response;
import springboot.demo.test.entity.Order;
import springboot.demo.test.entity.User;
import springboot.demo.test.service.OrderService;
import springboot.demo.test.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Api("订单信息管理")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

   @GetMapping("list")
    public Response<List<Order>> list () {
       return new Response<>(orderService.list());
   }
}
