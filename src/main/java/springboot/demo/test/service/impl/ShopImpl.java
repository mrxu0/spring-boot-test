package springboot.demo.test.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.demo.test.entity.Shop;
import springboot.demo.test.mapper.ShopMapper;
import springboot.demo.test.service.ShopService;

@Service
public class ShopImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService {
}
