package org.tiankafei.multidatasource.secondary.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tiankafei.multidatasource.secondary.entity.UserInfoJpaEntity;

/**
 * @author 魏双双
 * @since 1.0
 **/
public interface UserInfoJpa<T> extends JpaRepository<UserInfoJpaEntity, Long> {
}
