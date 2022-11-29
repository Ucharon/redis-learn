package cn.homyit.service;

import cn.homyit.dto.Result;
import cn.homyit.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author charon
* @description 针对表【tb_shop】的数据库操作Service
* @createDate 2022-11-10 21:42:14
*/
public interface ShopService extends IService<Shop> {

    Result queryById(Long id);

    void update(Shop shop);
}
