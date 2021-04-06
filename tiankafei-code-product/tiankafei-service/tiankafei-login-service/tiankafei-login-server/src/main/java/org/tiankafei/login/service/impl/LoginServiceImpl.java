package org.tiankafei.login.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.json.JSONUtil;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiankafei.login.bean.QueryUserClient;
import org.tiankafei.login.mapper.LoginMapper;
import org.tiankafei.login.model.LoginResultDto;
import org.tiankafei.login.service.CaptchaService;
import org.tiankafei.login.service.EncryptionService;
import org.tiankafei.login.service.LoginService;
import org.tiankafei.user.cache.UserInfoCache;
import org.tiankafei.user.cache.enums.UserCacheEnums;
import org.tiankafei.user.enums.UserEnums;
import org.tiankafei.user.enums.UserStatusEnums;
import org.tiankafei.user.vo.LoginParamVo;
import org.tiankafei.user.vo.MenuInfoVo;
import org.tiankafei.user.vo.RoleInfoVo;
import org.tiankafei.user.vo.UserInfoVo;
import org.tiankafei.user.vo.UserLoginVo;
import org.tiankafei.web.common.exception.LoginException;
import org.tiankafei.web.common.exception.VerificationException;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private UserInfoCache userInfoCache;

    @Autowired
    private QueryUserClient queryUserClient;

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private EncryptionService encryptionService;

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
     * 这一步不需要----6.如果用户存在，密码输入错误，则把该用户信息取出，放入缓存中，下次直接从缓存中取数进行比对
     * 7.如果验证通过，根据用户id获取用户详细数据和角色及功能清单相关数据保存在缓存中。
     * 8.获取用户详细数据信息
     * 9.获取用户的角色
     * 10.获取用户角色对应的功能清单
     * 11.组装数据关系（去重，排序）返回前端
     *
     * @param loginParamVo
     * @throws LoginException
     */
    @Override
    public LoginResultDto login(LoginParamVo loginParamVo) throws Exception {
        String keywords = loginParamVo.getKeywords();
        String password = loginParamVo.getPassword();
        // 0.验证数据合法性
        checkDataValid(loginParamVo);

        // 不存在的用户名，会放进缓存中，仅允许查询一次数据库，避免缓存穿透的问题
        UserInfoVo userInfo = userInfoCache.getUserInfo(keywords, password);
        ///
//        if (userInfo != null) {
//            String token = SecureUtil.md5(JSONUtil.toJsonStr(userInfo));
//            return token;
//        }

        // 根据用户名查询用户对象
        UserLoginVo userLoginQueryVo = queryUserClient.login(loginParamVo.getLoginType(), keywords);
        if (userLoginQueryVo != null) {
            // TODO 密码规则修改 验证密码是否正确
            String inputPassword = encryptionService.encryption(loginParamVo.getPassword());
            if (!userLoginQueryVo.getPassword().equals(inputPassword)) {
                throw new LoginException(UserCacheEnums.LOGIN_ERROR.getCode());
            }

            String status = userLoginQueryVo.getStatus();
            if (UserStatusEnums.DISABLE.getCode().equalsIgnoreCase(status)) {
                throw new LoginException("该账号已经被禁用！");
            } else if (UserStatusEnums.EXPIRATION_DATE.getCode().equalsIgnoreCase(status)) {
                Timestamp expirationDate = userLoginQueryVo.getExpirationDate();
                boolean isExpirationFlag = expirationDate != null && System.currentTimeMillis() > expirationDate.getTime();
                if (isExpirationFlag) {
                    throw new LoginException("该账号已经过期，请重新续约！");
                }
            }
            // 登录成功，获取其他用户数据
            Long userId = userLoginQueryVo.getId();
            try {
                // 获取用户、角色、功能的所有数据
                UserInfoVo userInfoQueryVo = getSysUserInfoQueryVo(userId);
                // TODO 生成token，暂时使用md5的方式对对象进行摘要
                String token = encryptionService.token(JSONUtil.toJsonStr(userInfoQueryVo));
                // 存放缓存
                userInfoCache.setUserInfo(userInfoQueryVo, token);

                return new LoginResultDto().setId(userInfoQueryVo.getId()).setToken(token);
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("获取用户数据发生异常！");
            }
        } else {
            // 当前用户名不存在，存放空值到缓存中，避免缓存穿透
            userInfoCache.setUsernameNullValue(keywords);
            throw new LoginException(UserCacheEnums.LOGIN_ERROR.getCode());
        }
    }

    @Override
    public UserInfoVo getUserInfo(String token) throws Exception {
        UserInfoVo userInfo = userInfoCache.getUserInfo(token);
        return userInfo;
    }

    /**
     * 验证数据合法性
     *
     * @param loginParamVo
     * @throws LoginException
     */
    private void checkDataValid(LoginParamVo loginParamVo) throws LoginException {
        try {
            // 输入的登录用户名
            String keywords = loginParamVo.getKeywords();

            // 登录类型
            Integer loginType = loginParamVo.getLoginType();
            if (loginType == null || loginType == 0) {
                // 验证并设置登录类型
                if (Validator.isEmail(keywords)) {
                    loginType = UserEnums.EMAIL.getCode();
                } else if (Validator.isMobile(keywords)) {
                    loginType = UserEnums.PHONE.getCode();
                } else if (Validator.isGeneral(keywords)) {
                    loginType = UserEnums.USER_NAME.getCode();
                } else {
                    throw new LoginException("登录用户名不符合要求，请重新输入！");
                }
                // 设置登录类型
                loginParamVo.setLoginType(loginType);
            } else {
                boolean validatorFlag = false;
                if (UserEnums.USER_NAME.getCode() == loginType) {
                    validatorFlag = Validator.isGeneral(keywords);
                } else if (UserEnums.PHONE.getCode() == loginType) {
                    validatorFlag = Validator.isMobile(keywords);
                } else if (UserEnums.EMAIL.getCode() == loginType) {
                    validatorFlag = Validator.isEmail(keywords);
                }
                if (!validatorFlag) {
                    throw new LoginException("登录用户名不符合要求，请重新输入！");
                }
            }
            // 验证码
            boolean verifyCaptchaFlag = captchaService.verifyCaptcha(loginParamVo.getUuid(), loginParamVo.getVerificationCode());
            if (!verifyCaptchaFlag) {
//                throw new LoginException("验证码输入错误，请重新输入！");
            }
        } catch (VerificationException e) {
            e.printStackTrace();
            throw new LoginException("验证码校验异常！");
        }
    }

    private UserInfoVo getSysUserInfoQueryVo(Long userId) {
        UserInfoVo userInfoVo = loginMapper.getSysUserAndRoleAndFeatureById(userId);
        // 设置给当前用户分配的角色集合
        List<RoleInfoVo> roleInfoList = userInfoVo.getUserRoleList().stream().map(userRoleVo -> userRoleVo.getRoleInfoVo()).collect(Collectors.toList());
        userInfoVo.setRoleInfoList(roleInfoList);

        // 获取去重的功能清单集合
        Set<MenuInfoVo> menuInfoSet = userInfoVo.getUserRoleList().stream().flatMap(userRoleVo -> userRoleVo.getRoleInfoVo().getRoleMenuList().stream()).map(roleMenuVo -> roleMenuVo.getMenuInfoVo()).collect(Collectors.toSet());
        // 找出所有的非跟节点
        Map<Integer, List<MenuInfoVo>> menuInfoListMap = menuInfoSet.stream().filter(sysMenuInfoQueryVo -> sysMenuInfoQueryVo.getParentId() != null).collect(Collectors.groupingBy(MenuInfoVo::getParentId));

        // 找出根节点，并根据id找出所有的子节点，并从小到大排序
        List<MenuInfoVo> rootMenuInfoList = menuInfoSet.stream()
                .map(menuInfoVo -> {
                    Long id = menuInfoVo.getId();
                    if (menuInfoListMap.containsKey(id)) {
                        List<MenuInfoVo> menuInfoList = menuInfoListMap.get(id);
                        // 排序
                        List<MenuInfoVo> sortedMenuInfoList = menuInfoList.stream().sorted(Comparator.comparing(MenuInfoVo::getSerialNumber)).collect(Collectors.toList());
                        menuInfoVo.setMenuInfoList(sortedMenuInfoList);
                    }
                    return menuInfoVo;
                })
                .filter(sysMenuInfoQueryVo -> sysMenuInfoQueryVo.getParentId() == null)
                .sorted(Comparator.comparing(MenuInfoVo::getSerialNumber))
                .collect(Collectors.toList());
        // 设置当前用户对应的功能菜单的权限集合
        userInfoVo.setMenuInfoList(rootMenuInfoList);

        return userInfoVo;
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
