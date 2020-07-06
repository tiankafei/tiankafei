package org.tiankafei.user.login.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.user.login.bean.GetLoginClient;
import org.tiankafei.user.login.entity.LoginEntity;
import org.tiankafei.user.enums.LoginEnums;
import org.tiankafei.user.login.mapper.LoginMapper;
import org.tiankafei.user.login.param.LoginQueryVo;
import org.tiankafei.user.login.service.CaptchaService;
import org.tiankafei.user.login.service.LoginService;
import org.tiankafei.web.common.exception.LoginException;
import org.tiankafei.web.common.exception.VerificationException;
import org.tiankafei.web.common.service.impl.BaseServiceImpl;

import java.util.Set;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
public class LoginServiceImpl extends BaseServiceImpl<LoginMapper, LoginEntity> implements LoginService {

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private GetLoginClient loginClient;

    /**
     * 针对用户登录的这个场景，用户数据不需要进行数据预热
     * <p>
     * 缓存常见的问题及解决方案
     * 1.缓存穿透：同一个key（数据库中没有的key），频繁发起请求，当这个key在数据库中不存在时，用户端频繁使用这一个值不停的发送请求，会造成请求穿过缓存，到达数据库的情况
     * 1.解决方案：把这一个key存放在缓存中，只不过值是空的
     * 2.缓存击穿：每次都使用不同的key，且这些key在数据库中都不存在，频繁发起请求，会造成请求穿过缓存，到达数据库的情况
     * 2.解决方案：使用布隆过滤器，把数据库的值都缓存到缓存中，就不会造成请求频繁到达数据库的问题
     * 3.缓存雪崩：同一时间，大量的key值过期，且大量的请求涌入，致使大部分请求穿过缓存，到达数据库的情况
     * 3.解决方案：对key的过期时间使用不同的间隔，以达到不会在同一时间造成大量的key失效的问题
     * <p>
     * 0.验证传入数据（验证码，且用户名、邮箱、手机号码）的合法性
     * 1.从当前缓存中查询用户信息，
     * 2.如果存在，说明已经登录，取出缓存的数据，直接返回，
     * 3.如果不存在，说明没有登录过，去数据库读取数据进行验证
     * 4.如果用户名不存在，则以该用户名为key，空值存储到缓存中，避免下次使用该不存在的用户访问时造成缓存穿透的问题
     * 5.如果用户端暴力频繁使用不同的用户名进行暴力登录，此时就要使用布隆过滤器，把数据库中的所有用户名缓存在缓存中，以屏蔽缓存击穿的问题
     * 6.如果用户存在，密码输入错误，则把该用户信息取出，放入缓存中，下次直接从缓存中取数进行比对
     * 7.如果验证通过，根据用户id获取用户详细数据和角色及功能清单相关数据保存在缓存中。
     * 8.获取用户详细数据信息
     * 9.获取用户的角色
     * 10.获取用户角色对应的功能清单
     * 11.组装数据关系（去重，排序）返回前端
     *
     * @param loginQueryVo
     * @throws LoginException
     */
    @Override
    public void login(LoginQueryVo loginQueryVo, HttpServletRequest request) throws LoginException {
        // 验证数据合法性
        checkDataValid(loginQueryVo, request);

        // 获取用户信息对象
        LoginEntity loginEntity = loginClient.doHandler(loginQueryVo.getLoginType(), loginQueryVo);
        System.out.println(loginEntity);


    }

    /**
     * TODO 判断用户账户属于什么登录类型
     *
     * @param userAccount
     * @return
     */
    private Integer getLoginType(String userAccount) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();

        Set<ConstraintViolation<String>> set = validator.validate(userAccount);
        for (ConstraintViolation<String> constraintViolation : set) {
            System.out.println(constraintViolation.getMessage());
        }


        return LoginEnums.MORE.getCode();
    }

    /**
     * 验证数据合法性
     *
     * @param loginQueryVo
     * @param request
     */
    private void checkDataValid(LoginQueryVo loginQueryVo, HttpServletRequest request) throws LoginException {
        try {
            // 用户名
            // 邮箱
            // 手机号码
            // 是否合法


            Integer loginType = loginQueryVo.getLoginType();
            if(loginType == null || loginType == 0){
                loginQueryVo.setLoginType(getLoginType(loginQueryVo.getUserAccount()));
            }

            boolean verifyCaptchaFlag = captchaService.verifyCaptcha(loginQueryVo.getVerificationCode(), request);
            if (verifyCaptchaFlag) {
                // 验证完成，删除
                captchaService.removeCaptcha(request);
            } else {
//                throw new LoginException("验证码输入错误，请重新输入！");
            }
        } catch (VerificationException e) {
            e.printStackTrace();
            throw new LoginException("验证码校验异常！");
        }
    }

    /**
     * 1.从缓存中删除当前用户信息
     * 1.1同步方式从缓存中删除用户信息
     * 1.2异步(MQ)方式从缓存中删除用户信息
     * 2.返回注销成功
     *
     * @param userId
     * @throws LoginException
     */
    @Override
    public void logout(String userId) throws LoginException {

    }

}
