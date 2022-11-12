package cn.homyit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.homyit.entity.Blog;
import cn.homyit.service.BlogService;
import cn.homyit.mapper.BlogMapper;
import org.springframework.stereotype.Service;

/**
* @author charon
* @description 针对表【tb_blog】的数据库操作Service实现
* @createDate 2022-11-10 21:42:14
*/
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog>
    implements BlogService{

}




