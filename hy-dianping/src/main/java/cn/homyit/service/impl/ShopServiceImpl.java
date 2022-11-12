package cn.homyit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.homyit.entity.Shop;
import cn.homyit.service.ShopService;
import cn.homyit.mapper.ShopMapper;
import org.springframework.stereotype.Service;

/**
* @author charon
* @description 针对表【tb_shop】的数据库操作Service实现
* @createDate 2022-11-10 21:42:14
*/
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop>
    implements ShopService{

}




