package cn.homyit;

import cn.homyit.entity.Shop;
import cn.homyit.service.ShopService;
import cn.homyit.service.impl.ShopServiceImpl;
import cn.homyit.utils.CacheClient;
import cn.homyit.utils.RedisConstants;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class HyDianpingApplicationTests {

    @Resource
    private ShopServiceImpl shopService;

    @Resource
    private CacheClient cacheClient;

    @Test
    void contextLoads() {
    }

    @Test
    void testSaveShop() throws InterruptedException {
        //shopService.saveShop2Redis(1L, 10L);
        Shop shop = shopService.getById(1L);
        cacheClient.setWithLogicalExpire(RedisConstants.CACHE_SHOP_KEY + 1L, shop, 10L, TimeUnit.SECONDS);
    }

}
