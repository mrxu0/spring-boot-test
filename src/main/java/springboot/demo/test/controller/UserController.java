package springboot.demo.test.controller;

import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.demo.common.resp.Response;
import springboot.demo.test.entity.User;
import springboot.demo.test.mapper.UserMapper;
import springboot.demo.test.service.UserService;
import springboot.demo.common.PageInfo;

import javax.validation.Valid;
import java.util.List;

@Api("用户信息管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("添加 100 个用户")
    @GetMapping("/insert100")
    public Response insert100() {
        userService.insert100();
        return new Response();
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/userlist")
    public Response<List<User>> userlist() {
        return new Response<>(userService.getAll());
    }


    @GetMapping("/getone/{id}")
    public Response<User> getone(@PathVariable Long id) {
        return new Response<>(userService.getOne(id));
    }

    @ApiOperation("通过 id 删除用户")
    @GetMapping("/delete/{id}")
    public Response delete(@PathVariable Long id) {
        Response res = new Response<>();
        userService.delete(id);
        res.setMessage("删除成功");
        return res;
    }

    @ApiOperation("更新某个用户")
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public Response update(@Valid Long id, @Valid String name, @Valid String pass) {
        Response res = new Response<>();
        User user = new User();
        user.setId(id);
        user.setUserName(name);
        user.setPassWord(pass);
        userService.update(user);
        res.setMessage("更新成功");
        return res;
    }

    @ApiOperation("分页查询用户数据")
    @RequestMapping(value="/findByPage/{pageNo}/{pageSize}", method = RequestMethod.GET)
    public Response<PageInfo<User>> findByPage(@PathVariable int pageNo, @PathVariable int pageSize) {
        Page<User> userList = userService.findByPage(pageNo, pageSize);
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return new Response(pageInfo);
    }
}
