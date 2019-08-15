package springboot.demo.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;
import springboot.demo.test.entity.Shop;
import springboot.demo.test.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    String insert100 ();

    List<User> getAll ();

    User getOne(Long id);

    void update(User user);

    void delete(Long id);

    Page<User> findByPage(int pageNo, int pageSize);

}
