package org.tiankafei.user.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import org.tiankafei.user.login.param.LoginQueryVo;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Repository
public interface LoginMapper extends BaseMapper<LoginQueryVo> {


}