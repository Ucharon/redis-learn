package cn.homyit.service.impl;

import cn.homyit.enums.ExceptionCodeEnum;
import cn.homyit.exception.BizException;
import cn.homyit.utils.RedisConstants;
import cn.homyit.utils.SystemConstants;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.homyit.entity.ShopType;
import cn.homyit.service.ShopTypeService;
import cn.homyit.mapper.ShopTypeMapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author charon
 * @description 针对表【tb_shop_type】的数据库操作Service实现
 * @createDate 2022-11-10 21:42:14
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType>
        implements ShopTypeService {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Override
    public List<ShopType> queryList() {
        //1.从redis查找缓存
        String key = RedisConstants.CACHE_SHOP_TYPE_KEY;
        List<String> shopTypesJSON = stringRedisTemplate.opsForList().range(key, 0, -1);

        //2.如果存在，直接返回
        if (shopTypesJSON != null && shopTypesJSON.size() != 0) {
            return shopTypesJSON.stream()
                    .map(s -> JSONUtil.toBean(s, ShopType.class))
                    .collect(Collectors.toList());
        }

        //3.不存在，则在数据库查询
        List<ShopType> shopTypes = lambdaQuery().orderByAsc(ShopType::getSort).list();

        //4.不存在，直接返回没有查询到
        if (shopTypes == null) {
            throw new BizException(ExceptionCodeEnum.SHOP_TYPE_NOT_EXIT);
        }

        //5.存在，使用List结构将数据存入redis
        shopTypesJSON = shopTypes.stream()
                .map(JSONUtil::toJsonStr)
                .collect(Collectors.toList());

        stringRedisTemplate.opsForList().rightPushAll(key, shopTypesJSON);
        //6.返回
        return shopTypes;
    }
}




