package springboot.demo.test.service;

import springboot.demo.test.entity.User;

import java.util.List;

public interface UserService {
    String insert100 ();

    List<User> getAll ();

    User getOne(Long id);

    void update(User user);

    void delete(Long id);
}
