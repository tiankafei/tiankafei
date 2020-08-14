package org.tiankafei.multidatasource.primary.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.tiankafei.multidatasource.primary.entity.BlogInfoEntity;

/**
 * @author 魏双双
 * @since 1.0
 **/
public interface BlogInfoJpa<T> extends JpaRepository<BlogInfoEntity, Long> {
}
