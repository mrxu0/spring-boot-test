package springboot.demo.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.test.entity.UserEntity;
import springboot.demo.test.mapper.UserMapper;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    public List<UserEntity> getUsers() {
        List<UserEntity> userList = userMapper.getAll();
        return userList;
    }

    @RequestMapping("/insert")
    public String insert() {
        UserEntity user = new UserEntity("徐", "root");
        userMapper.insert(user);
        return "成功";
    }
}
