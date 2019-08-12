package springboot.demo.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import springboot.demo.test.entity.UserEntity;

import java.util.List;

public interface UserMapper {

    List<UserEntity> getAll();

//    UserEntity getOne(Long id);
//
    void insert(UserEntity user);
//
//    void update(UserEntity user);
//
//    void delete(Long id);

}

