package springboot.demo.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.common.Properties;
import springboot.demo.test.dao.Test;

import java.util.Date;

@RestController
public class TestController {
    @RequestMapping("/user")
    public Test index() {
        Test test = new Test();
        test.setAge(200);
        test.setName("徐月超s");
        test.setDate(new Date());
        return test;
    }
    @RequestMapping("/pro")
    public Properties pro() {
        Properties p = new Properties();
        return p;
    }
}
