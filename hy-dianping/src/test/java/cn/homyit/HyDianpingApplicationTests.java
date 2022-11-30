package cn.homyit;

import cn.homyit.service.ShopService;
import cn.homyit.service.impl.ShopServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class HyDianpingApplicationTests {

    @Resource
    private ShopServiceImpl shopService;

    @Test
    void contextLoads() {
    }

    @Test
    void testSaveShop() throws InterruptedException {
        shopService.saveShop2Redis(1L, 10L);
    }

}
