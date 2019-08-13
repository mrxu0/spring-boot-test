package springboot.demo.test.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.demo.test.entity.User;
import springboot.demo.test.mapper.UserMapper;
import springboot.demo.test.service.UserService;
import springboot.demo.utils.RandomString;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String insert100() {
        for (int i = 0; i < 100; i ++) {
            RandomString rs = new RandomString(10);
            userMapper.insert(new User(rs.getRandom(),rs.getRandom()));
        }
        return "成功";
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User getOne(Long id) {
        return userMapper.getOne(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }

    @Override
    public Page<User> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return (Page<User>) userMapper.findByPage();
    }
}
