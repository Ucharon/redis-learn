package cn.homyit.service;

import cn.homyit.dto.LoginFormDTO;
import cn.homyit.dto.Result;
import cn.homyit.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpSession;

/**
* @author charon
* @description 针对表【tb_user】的数据库操作Service
* @createDate 2022-11-10 21:42:14
*/
public interface UserService extends IService<User> {

    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);
}
