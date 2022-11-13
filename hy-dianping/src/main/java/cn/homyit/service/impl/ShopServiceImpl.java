package cn.homyit.service.impl;

import cn.homyit.dto.Result;
import cn.homyit.enums.ExceptionCodeEnum;
import cn.homyit.utils.RedisConstants;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.homyit.entity.Shop;
import cn.homyit.service.ShopService;
import cn.homyit.mapper.ShopMapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author charon
* @description 针对表【tb_shop】的数据库操作Service实现
* @createDate 2022-11-10 21:42:14
*/
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop>
    implements ShopService{

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryById(Long id) {
        //1.从redis查询商铺缓存
        String key = RedisConstants.CACHE_SHOP_KEY + id;
        String shopJson = stringRedisTemplate.opsForValue().get(key);

        //2.判断是否存在
        if (StrUtil.isNotBlank(shopJson)) {
            //3.存在，直接返回
            Shop shop = JSONUtil.toBean(shopJson, Shop.class);
            return Result.success(shop);
        }

        //4.不存在，根据id查询数据库
        Shop shop = getById(id);

        if (shop == null) {
            //5.不存在，返回错误
            return Result.error(ExceptionCodeEnum.SHOP_NOT_EXIT);
        }

        //6.存在，写入redis
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(shop));

        //7.返回
        return Result.success(shop);
    }
}




