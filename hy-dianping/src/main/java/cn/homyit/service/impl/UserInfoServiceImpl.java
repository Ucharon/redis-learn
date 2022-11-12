package cn.homyit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.homyit.entity.UserInfo;
import cn.homyit.service.UserInfoService;
import cn.homyit.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author charon
* @description 针对表【tb_user_info】的数据库操作Service实现
* @createDate 2022-11-10 21:42:14
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




