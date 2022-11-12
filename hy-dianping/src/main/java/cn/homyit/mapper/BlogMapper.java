package cn.homyit.mapper;

import cn.homyit.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author charon
* @description 针对表【tb_blog】的数据库操作Mapper
* @createDate 2022-11-10 21:42:14
* @Entity cn.homyit.entity.Blog
*/
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

}




