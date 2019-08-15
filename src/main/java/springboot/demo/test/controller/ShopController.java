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
import springboot.demo.test.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Api("商品信息管理")
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopMapper shopMapper;

    @ApiOperation("获取商品列表")
    @GetMapping("/shoplist")
    public Response<List<Shop>> userlist() {
        return new Response<>(shopMapper.selectList(null));
    }
    @ApiOperation("添加商品")
    @GetMapping("/insert")
    public Response insert() {
        Response res = new Response();
        Shop shop = new Shop();
        shop.setDes("第一件商品");
        shop.setName("商品");
        shop.setPrice(200.00);
        shopMapper.insert(shop);
        res.setMessage("成功");
        return res;
    }
}
