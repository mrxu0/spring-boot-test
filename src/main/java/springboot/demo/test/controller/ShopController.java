package springboot.demo.test.controller;

import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.demo.common.PageInfo;
import springboot.demo.common.resp.Response;
import springboot.demo.test.entity.Shop;
import springboot.demo.test.entity.User;
import springboot.demo.test.mapper.ShopMapper;
import springboot.demo.test.mapper.UserMapper;
import springboot.demo.test.service.ShopService;
import springboot.demo.test.service.UserService;
import springboot.demo.test.service.impl.ShopImpl;

import javax.validation.Valid;
import java.util.List;

@Api("商品信息管理")
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @ApiOperation("获取商品列表")
    @GetMapping("/shoplist")
    public Response<List<Shop>> userlist() {
        return new Response<>(shopService.list());
    }


    @ApiOperation("添加商品")
    @PostMapping("/insert")
    public Response insert(Shop shop) {
        Response res = new Response();
        shopService.save(shop);
        res.setMessage("成功");
        return res;
    }

}
