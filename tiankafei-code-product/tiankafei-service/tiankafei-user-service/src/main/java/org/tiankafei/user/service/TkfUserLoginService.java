package org.tiankafei.user.service;

import org.tiankafei.user.entity.TkfUserLoginEntity;
import org.tiankafei.user.param.TkfUserLoginPageQueryParam;
import org.tiankafei.user.param.TkfUserLoginQueryParam;
import org.tiankafei.user.vo.TkfUserLoginQueryVo;
import org.tiankafei.web.common.service.BaseService;
import org.tiankafei.web.common.vo.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 用户登录信息表 服务类
 * </pre>
 *
 * @author tiankafei
 * @since 2020-06-30
 */
public interface TkfUserLoginService extends BaseService<TkfUserLoginEntity> {

    /**
     * 验证用户名是否存在
     * @param username
     * @return
     * @throws Exception
     */
    boolean checkUsernameExists(String username) throws Exception;

    /**
     * 验证邮箱是否存在
     * @param email
     * @return
     * @throws Exception
     */
    boolean checkEmailExists(String email) throws Exception;

    /**
     * 验证手机号码是否存在
     * @param telephone
     * @return
     * @throws Exception
     */
    boolean checkTelephoneExists(String telephone) throws Exception;

    /**
     * 校验 用户登录信息表 是否已经存在
     *
     * @param tkfUserLoginQueryParam
     * @return
     * @throws Exception
     */
    boolean checkTkfUserLoginExists(TkfUserLoginQueryParam tkfUserLoginQueryParam) throws Exception;

    /**
     * 保存 用户登录信息表
     *
     * @param tkfUserLoginQueryVo
     * @return
     * @throws Exception
     */
    Object saveTkfUserLogin(TkfUserLoginQueryVo tkfUserLoginQueryVo) throws Exception;
    
    /**
     * 保存 用户登录信息表 集合
     *
     * @param tkfUserLoginQueryVoList
     * @return
     * @throws Exception
     */
    boolean saveTkfUserLoginList(List<TkfUserLoginQueryVo> tkfUserLoginQueryVoList) throws Exception;

    /**
     * 修改 用户登录信息表
     *
     * @param tkfUserLoginQueryVo
     * @return
     * @throws Exception
     */
    boolean updateTkfUserLogin(TkfUserLoginQueryVo tkfUserLoginQueryVo) throws Exception;

    /**
     * 删除 用户登录信息表
     *
     * @param ids
     * @return
     * @throws Exception
     */
    boolean deleteTkfUserLogin(String ids) throws Exception;
	
    /**
     * 根据条件删除 用户登录信息表
     *
     * @param tkfUserLoginQueryParam
     * @return
     * @throws Exception
     */
    boolean deleteTkfUserLogin(TkfUserLoginQueryParam tkfUserLoginQueryParam) throws Exception;

    /**
     * 根据ID获取 用户登录信息表 对象
     *
     * @param id
     * @return
     * @throws Exception
     */
     TkfUserLoginQueryVo getTkfUserLoginById(Serializable id) throws Exception;

    /**
     * 获取 用户登录信息表 分页对象列表
     *
     * @param tkfUserLoginPageQueryParam
     * @return
     * @throws Exception
     */
    Paging<TkfUserLoginQueryVo> getTkfUserLoginPageList(TkfUserLoginPageQueryParam tkfUserLoginPageQueryParam) throws Exception;

    /**
     * 获取 用户登录信息表 对象列表
     *
     * @param tkfUserLoginQueryParam
     * @return
     * @throws Exception
     */
     List<TkfUserLoginQueryVo> getTkfUserLoginList(TkfUserLoginQueryParam tkfUserLoginQueryParam) throws Exception;
    
    /**
     * 计算 用户登录信息表 总记录数
     *
     * @param tkfUserLoginQueryParam
     * @return
     * @throws Exception
     */
    int countTkfUserLogin(TkfUserLoginQueryParam tkfUserLoginQueryParam) throws Exception;

}