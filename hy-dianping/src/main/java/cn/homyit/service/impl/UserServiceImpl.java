package cn.homyit.service.impl;

import cn.homyit.dto.LoginFormDTO;
import cn.homyit.dto.Result;
import cn.homyit.enums.ExceptionCodeEnum;
import cn.homyit.utils.RegexUtils;
import cn.homyit.utils.SystemConstants;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.homyit.entity.User;
import cn.homyit.service.UserService;
import cn.homyit.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
* @author charon
* @description 针对表【tb_user】的数据库操作Service实现
* @createDate 2022-11-10 21:42:14
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public Result sendCode(String phone, HttpSession session) {
        //1.校验手机号
        if (RegexUtils.isPhoneInvalid(phone)) {
            //2.如果不符合，返回错误信息
            return Result.error(ExceptionCodeEnum.PHONENUMBER_FORMAT_INVALID);
        }

        //3.符合，生成验证码
        String code = RandomUtil.randomNumbers(6);

        //4.保存验证码到session
        session.setAttribute("code", code);

        //5.发送验证码
        log.info("发送短信验证码成功，验证码：{}", code);

        //返回success
        return Result.success();
    }

    @Override
    public Result login(LoginFormDTO loginForm, HttpSession session) {
        //1.校验手机号
        String phone = loginForm.getPhone();
        if (RegexUtils.isPhoneInvalid(phone)) {
            //2.如果不符合，返回错误信息
            return Result.error(ExceptionCodeEnum.PHONENUMBER_FORMAT_INVALID);
        }

        //2.校验验证码
        String cacheCode = (String) session.getAttribute("code");
        String code = loginForm.getCode();
        if (cacheCode == null || !cacheCode.equals(code)) {
            //3.不一致，报错
            return Result.error(ExceptionCodeEnum.CODE_INVALID);
        }

        //4.一致，根据手机号查询用户 select * from tb_user where phone = ?
        User user = lambdaQuery().eq(User::getPhone, phone).one();

        //5.判断用户是否存在

        if (user == null) {
            //6.不存在，创建全新用户
            user = createUserWithPhone(phone);
        }

        //7.保存用户信息到session
        session.setAttribute("user", user);

        return Result.success();
    }

    private User createUserWithPhone(String phone) {
        //创建用户
        User user = new User();
        user.setPhone(phone);
        user.setNickName(SystemConstants.USER_NICK_NAME_PREFIX + RandomUtil.randomString(10));
        //保存用户
        save(user);

        return user;
    }
}




