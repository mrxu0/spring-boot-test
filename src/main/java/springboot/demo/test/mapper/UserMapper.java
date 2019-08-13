package springboot.demo.test.mapper;

import springboot.demo.test.entity.User;

import java.util.List;
public interface UserMapper {

    List<User> getAll();

    void insert(User user);

    User getOne(Long id);

    void update(User user);

    void delete(Long id);

    List<User>  findByPage();

}

