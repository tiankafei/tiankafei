package org.tiankafei.ui.control.constants;

import com.google.common.collect.Lists;
import java.util.List;
import org.tiankafei.ui.control.abstractinterface.AbstractTiankafeiConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiDefaultConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiEqualConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiIntervalConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiLengthConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiLessThanConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiLessThanEqualConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiListConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiMoreThanConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiMoreThanEqualConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiNoEqualConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiNoListConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiNoNullConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiNoPrefixConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiNoSuffixConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiNullConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiPrefixConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiSubstrConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiSuffixConditionDTO;

/**
 * 自定义过滤条件配置
 *
 * @author tiankafei1
 */
public class TiankafeiConditionConstants {

    /**
     * 自定义过滤条件操作并且
     */
    public static final String TIANKAFEI_HANDLE_TYPE_AND = "AND";

    /**
     * 自定义过滤条件操作或者
     */
    public static final String TIANKAFEI_HANDLE_TYPE_OR = "OR";

    /**
     * 自定义条件字段
     */
    public static final String TIANKAFEI_CONDITION_COLUMN = "TIANKAFEI_CONDITION_COLUMN";

    /**
     * 请选择
     */
    public static final String TIANKAFEI_DEFAULT_CONDITION = "TIANKAFEI_DEFAULT_CONDITION";

    /**
     * 截取
     */
    public static final String TIANKAFEI_SUBSTR_CONDITION = "TIANKAFEI_SUBSTR_CONDITION";

    /**
     * 长度
     */
    public static final String TIANKAFEI_LENGTH_CONDITION = "TIANKAFEI_LENGTH_CONDITION";

    /**
     * 等于
     */
    public static final String TIANKAFEI_EQUAL_CONDITION = "TIANKAFEI_EQUAL_CONDITION";

    /**
     * 不等于
     */
    public static final String TIANKAFEI_NO_EQUAL_CONDITION = "TIANKAFEI_NO_EQUAL_CONDITION";

    /**
     * 大于
     */
    public static final String TIANKAFEI_MORE_THAN_CONDITION = "TIANKAFEI_MORE_THAN_CONDITION";

    /**
     * 大于等于
     */
    public static final String TIANKAFEI_MORE_THAN_EQUAL_CONDITION = "TIANKAFEI_MORE_THAN_EQUAL_CONDITION";

    /**
     * 小于
     */
    public static final String TIANKAFEI_LESS_THAN_CONDITION = "TIANKAFEI_LESS_THAN_CONDITION";

    /**
     * 小于等于
     */
    public static final String TIANKAFEI_LESS_THAN_EQUAL_CONDITION = "TIANKAFEI_LESS_THAN_EQUAL_CONDITION";

    /**
     * 区间
     */
    public static final String TIANKAFEI_INTERVAL_CONDITION = "TIANKAFEI_INTERVAL_CONDITION";

    /**
     * 前缀
     */
    public static final String TIANKAFEI_PREFIX_CONDITION = "TIANKAFEI_PREFIX_CONDITION";

    /**
     * 后缀
     */
    public static final String TIANKAFEI_SUFFIX_CONDITION = "TIANKAFEI_SUFFIX_CONDITION";

    /**
     * 非前缀
     */
    public static final String TIANKAFEI_NO_PREFIX_CONDITION = "TIANKAFEI_NO_PREFIX_CONDITION";

    /**
     * 非后缀
     */
    public static final String TIANKAFEI_NO_SUFFIX_CONDITION = "TIANKAFEI_NO_SUFFIX_CONDITION";

    /**
     * 为空
     */
    public static final String TIANKAFEI_NULL_CONDITION = "TIANKAFEI_NULL_CONDITION";

    /**
     * 非空
     */
    public static final String TIANKAFEI_NO_NULL_CONDITION = "TIANKAFEI_NO_NULL_CONDITION";

    /**
     * 列表
     */
    public static final String TIANKAFEI_LIST_CONDITION = "TIANKAFEI_LIST_CONDITION";

    /**
     * 非列表
     */
    public static final String TIANKAFEI_NO_LIST_CONDITION = "TIANKAFEI_NO_LIST_CONDITION";

    /**
     * 获取自定义过滤条件集合
     *
     * @return 自定义过滤条件集合
     */
    public static List<AbstractTiankafeiConditionDTO> getTiankafeiConditionList() {
        List<AbstractTiankafeiConditionDTO> tiankafeiConditionList = Lists.newArrayList();
        //请选择
        AbstractTiankafeiConditionDTO tiankafeiDefaultConditionDTO = new TiankafeiDefaultConditionDTO();
        tiankafeiConditionList.add(tiankafeiDefaultConditionDTO);
        //截取
        AbstractTiankafeiConditionDTO tiankafeiSubstrConditionDTO = new TiankafeiSubstrConditionDTO();
        tiankafeiConditionList.add(tiankafeiSubstrConditionDTO);
        //长度
        AbstractTiankafeiConditionDTO tiankafeiLengthConditionDTO = new TiankafeiLengthConditionDTO();
        tiankafeiConditionList.add(tiankafeiLengthConditionDTO);
        //等于
        AbstractTiankafeiConditionDTO tiankafeiEqualConditionDTO = new TiankafeiEqualConditionDTO();
        tiankafeiConditionList.add(tiankafeiEqualConditionDTO);
        //不等于
        AbstractTiankafeiConditionDTO tiankafeiNoEqualConditionDTO = new TiankafeiNoEqualConditionDTO();
        tiankafeiConditionList.add(tiankafeiNoEqualConditionDTO);
        //大于
        AbstractTiankafeiConditionDTO tiankafeiMoreThanConditionDTO = new TiankafeiMoreThanConditionDTO();
        tiankafeiConditionList.add(tiankafeiMoreThanConditionDTO);
        //大于等于
        AbstractTiankafeiConditionDTO tiankafeiMoreThanEqualConditionDTO = new TiankafeiMoreThanEqualConditionDTO();
        tiankafeiConditionList.add(tiankafeiMoreThanEqualConditionDTO);
        //小于
        AbstractTiankafeiConditionDTO tiankafeiLessThanConditionDTO = new TiankafeiLessThanConditionDTO();
        tiankafeiConditionList.add(tiankafeiLessThanConditionDTO);
        //小于等于
        AbstractTiankafeiConditionDTO tiankafeiLessThanEqualConditionDTO = new TiankafeiLessThanEqualConditionDTO();
        tiankafeiConditionList.add(tiankafeiLessThanEqualConditionDTO);
        //区间
        AbstractTiankafeiConditionDTO tiankafeiIntervalConditionDTO = new TiankafeiIntervalConditionDTO();
        tiankafeiConditionList.add(tiankafeiIntervalConditionDTO);
        //前缀
        AbstractTiankafeiConditionDTO tiankafeiPrefixConditionDTO = new TiankafeiPrefixConditionDTO();
        tiankafeiConditionList.add(tiankafeiPrefixConditionDTO);
        //后缀
        AbstractTiankafeiConditionDTO tiankafeiSuffixConditionDTO = new TiankafeiSuffixConditionDTO();
        tiankafeiConditionList.add(tiankafeiSuffixConditionDTO);
        //非前缀
        AbstractTiankafeiConditionDTO tiankafeiNoPrefixConditionDTO = new TiankafeiNoPrefixConditionDTO();
        tiankafeiConditionList.add(tiankafeiNoPrefixConditionDTO);
        //非后缀
        AbstractTiankafeiConditionDTO tiankafeiNoSuffixConditionDTO = new TiankafeiNoSuffixConditionDTO();
        tiankafeiConditionList.add(tiankafeiNoSuffixConditionDTO);
        //为空
        AbstractTiankafeiConditionDTO tiankafeiNullConditionDTO = new TiankafeiNullConditionDTO();
        tiankafeiConditionList.add(tiankafeiNullConditionDTO);
        //非空
        AbstractTiankafeiConditionDTO tiankafeiNoNullConditionDTO = new TiankafeiNoNullConditionDTO();
        tiankafeiConditionList.add(tiankafeiNoNullConditionDTO);
        //列表
        AbstractTiankafeiConditionDTO tiankafeiListConditionDTO = new TiankafeiListConditionDTO();
        tiankafeiConditionList.add(tiankafeiListConditionDTO);
        //非列表
        AbstractTiankafeiConditionDTO tiankafeiNoListConditionDTO = new TiankafeiNoListConditionDTO();
        tiankafeiConditionList.add(tiankafeiNoListConditionDTO);

        return tiankafeiConditionList;
    }

}
