package cn.homyit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.homyit.entity.BlogComments;
import cn.homyit.service.BlogCommentsService;
import cn.homyit.mapper.BlogCommentsMapper;
import org.springframework.stereotype.Service;

/**
* @author charon
* @description 针对表【tb_blog_comments】的数据库操作Service实现
* @createDate 2022-11-10 21:42:14
*/
@Service
public class BlogCommentsServiceImpl extends ServiceImpl<BlogCommentsMapper, BlogComments>
    implements BlogCommentsService{

}




