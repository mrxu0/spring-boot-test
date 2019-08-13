package springboot.demo.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.test.entity.User;
import springboot.demo.test.mapper.UserMapper;
import springboot.demo.test.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/insert100")
    public String insert100() {
        userService.insert100();
        return "成功";
    }

    @RequestMapping("/userlist")
    public List<User> userlist() {
        return userService.getAll();
    }

    @RequestMapping("/getone/{id}")
    public User getone(@PathVariable Long id) {
        return userService.getOne(id);
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "成功";
    }

//    @RequestMapping("/update/{id}")
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String update(@Valid Long id, @Valid String name, @Valid String pass) {
        User user = new User();
        user.setId(id);
        user.setUserName(name);
        user.setPassWord(pass);
        userService.update(user);
        return "成功";
    }
}
