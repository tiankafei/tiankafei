package org.tiankafei.multidatasource.jpa.secondary.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tiankafei.multidatasource.jpa.secondary.entity.UserInfoEntity;

/**
 * @author 魏双双
 * @since 1.0
 **/
public interface UserInfoJpa<T> extends JpaRepository<UserInfoEntity, Long> {
}
