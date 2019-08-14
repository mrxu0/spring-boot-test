package springboot.demo.test.controller;

import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.demo.test.entity.User;
import springboot.demo.test.service.UserService;
import springboot.demo.utils.PageInfo;

import javax.servlet.http.HttpServletRequest;
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
    public String insert100() {
        userService.insert100();
        return "成功";
    }

    @ApiOperation("获取用户列表")
    @GetMapping("/userlist")
    public List<User> userlist() {
        return userService.getAll();
    }


    @GetMapping("/getone/{id}")
    public User getone(@PathVariable Long id) {
        return userService.getOne(id);
    }

    @ApiOperation("通过 id 删除用户")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "成功";
    }

    @ApiOperation("更新某个用户")
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String update(@Valid Long id, @Valid String name, @Valid String pass) {
        User user = new User();
        user.setId(id);
        user.setUserName(name);
        user.setPassWord(pass);
        userService.update(user);
        return "成功";
    }

    @ApiOperation("分页查询用户数据")
    @RequestMapping(value="/findByPage/{pageNo}/{pageSize}", method = RequestMethod.GET)
    public PageInfo<User> findByPage(@PathVariable int pageNo, @PathVariable int pageSize) {
        Page<User> userList = userService.findByPage(pageNo, pageSize);
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return pageInfo;
    }
}
