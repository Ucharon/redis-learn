package cn.homyit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.homyit.entity.SeckillVoucher;
import cn.homyit.service.SeckillVoucherService;
import cn.homyit.mapper.SeckillVoucherMapper;
import org.springframework.stereotype.Service;

/**
* @author charon
* @description 针对表【tb_seckill_voucher(秒杀优惠券表，与优惠券是一对一关系)】的数据库操作Service实现
* @createDate 2022-11-10 21:42:14
*/
@Service
public class SeckillVoucherServiceImpl extends ServiceImpl<SeckillVoucherMapper, SeckillVoucher>
    implements SeckillVoucherService{

}




