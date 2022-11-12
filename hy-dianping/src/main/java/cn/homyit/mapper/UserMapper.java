package cn.homyit.mapper;

import cn.homyit.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author charon
* @description 针对表【tb_user】的数据库操作Mapper
* @createDate 2022-11-10 21:42:14
* @Entity cn.homyit.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




