package springboot.demo.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.test.dao.Test;

import java.util.Date;

@RestController
public class TestController {
    @RequestMapping("/userr")
    public Test index() {
        Test test = new Test();
        test.setAge(200);
        test.setName("徐月超");
        test.setDate(new Date());
        return test;
    }
}
