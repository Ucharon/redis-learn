package cn.homyit.mapper;

import cn.homyit.entity.SeckillVoucher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author charon
* @description 针对表【tb_seckill_voucher(秒杀优惠券表，与优惠券是一对一关系)】的数据库操作Mapper
* @createDate 2022-11-10 21:42:14
* @Entity cn.homyit.entity.SeckillVoucher
*/
@Mapper
public interface SeckillVoucherMapper extends BaseMapper<SeckillVoucher> {

}




