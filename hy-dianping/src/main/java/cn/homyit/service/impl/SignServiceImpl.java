package cn.homyit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.homyit.entity.Sign;
import cn.homyit.service.SignService;
import cn.homyit.mapper.SignMapper;
import org.springframework.stereotype.Service;

/**
* @author charon
* @description 针对表【tb_sign】的数据库操作Service实现
* @createDate 2022-11-10 21:42:14
*/
@Service
public class SignServiceImpl extends ServiceImpl<SignMapper, Sign>
    implements SignService{

}




