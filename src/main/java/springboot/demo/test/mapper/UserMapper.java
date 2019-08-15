package springboot.demo.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import springboot.demo.test.entity.User;

import java.util.List;
@Component
public interface UserMapper  extends BaseMapper<User> {

    List<User> getAll();

    User getOne(Long id);

    void update(User user);

    void delete(Long id);

    List<User>  findByPage();

}

