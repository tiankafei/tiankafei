package org.tiankafei.rule.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统规则设计对象
 * </p>
 *
 * @author tiankafei
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_rule_design")
@ApiModel(value = "RuleDesignEntity 对象", description = "系统规则设计对象")
public class RuleDesignEntity extends Model<RuleDesignEntity> {
}
