package cn.homyit.service;

import cn.homyit.dto.Result;
import cn.homyit.entity.Voucher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author charon
* @description 针对表【tb_voucher】的数据库操作Service
* @createDate 2022-11-10 21:42:14
*/
public interface VoucherService extends IService<Voucher> {

    void addSeckillVoucher(Voucher voucher);

    Result queryVoucherOfShop(Long shopId);
}
