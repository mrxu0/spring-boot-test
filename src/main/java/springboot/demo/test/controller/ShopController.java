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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Response res = new Response(shopService.save(shop));
        res.setMessage("成功");
        return res;
    }

    @ApiOperation("批量添加商品")
    @PostMapping("/saveBatch")
    public Response saveBatch(Shop shop) {
        Response res = new Response();
        ArrayList<Shop> list = new ArrayList<Shop>();
        for (int i = 0 ; i < 2; i++) {
            Shop sp = new Shop();
            sp.setDes(shop.getDes());
            sp.setName(shop.getName());
            sp.setPrice(shop.getPrice());
            list.add(sp);
        }
        res.setData(shopService.saveBatch(list));
        res.setMessage("成功");
        return res;
    }

    @ApiOperation("控制批量添加数量")
    @PostMapping("/saveBatchSize")
    public Response saveBatchSize(Shop shop) {
        Response res = new Response();
        ArrayList<Shop> list = new ArrayList<Shop>();
        for (int i = 0 ; i < 4; i++) {
            Shop sp = new Shop();
            sp.setDes(shop.getDes());
            sp.setName(shop.getName());
            sp.setPrice(shop.getPrice());
            list.add(sp);
        }
        res.setData(shopService.saveBatch(list, 1));
        res.setMessage("成功");
        return res;
    }

    @ApiOperation("存在更新，不存在添加")
    @PostMapping("/saveOrUpdateBatch")
    public Response saveOrUpdateBatch(Shop shop) {
        Response res = new Response();
        ArrayList<Shop> list = new ArrayList<Shop>();
        list.add(shop);
        res.setData(shopService.saveOrUpdateBatch(list));
        res.setMessage("成功");
        return res;
    }

    @ApiOperation("删除")
    @PostMapping("/removeByMap")
    public Response removeByMap (Shop shop) {
        Map<String, Object> map = new HashMap<>();
        map.put("price", shop.getPrice());
        return new Response(shopService.removeByMap(map));
    }
}
