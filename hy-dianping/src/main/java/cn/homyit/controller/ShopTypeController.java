package cn.homyit.controller;


import cn.homyit.dto.Result;
import cn.homyit.entity.ShopType;
import cn.homyit.service.ShopTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/shop-type")
public class ShopTypeController {
    @Resource
    private ShopTypeService typeService;

    @GetMapping("list")
    public Result<List<ShopType>> queryTypeList() {
        return Result.success(typeService.queryList());
    }
}
