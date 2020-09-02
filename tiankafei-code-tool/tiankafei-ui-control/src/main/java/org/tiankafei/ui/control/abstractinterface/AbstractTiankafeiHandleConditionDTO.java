package org.tiankafei.ui.control.abstractinterface;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import org.tiankafei.ui.control.condition.TiankafeiAndHandleConditionDTO;
import org.tiankafei.ui.control.condition.TiankafeiOrHandleConditionDTO;
import org.tiankafei.ui.control.constants.TiankafeiConditionConstants;

/**
 * 自定义过滤条件操作抽象对象
 *
 * @author tiankafei1
 */
public abstract class AbstractTiankafeiHandleConditionDTO implements Serializable {

    private static final long serialVersionUID = -4774183688067016230L;

    /**
     * 获取操作类型
     *
     * @return 操作类型
     */
    public abstract String getHandleType();

    /**
     * 逻辑运算符
     *
     * @return 逻辑运算符
     */
    @Override
    public abstract String toString();

    /**
     * 创建自定义过滤条件操作抽象对象
     *
     * @param handleType 操作类型
     * @return 自定义过滤条件操作抽象对象
     */
    public static AbstractTiankafeiHandleConditionDTO createAbstractTiankafeiHandleConditionDTO(String handleType) {
        AbstractTiankafeiHandleConditionDTO abstractTiankafeiHandleConditionDTO = null;
        if (TiankafeiConditionConstants.TIANKAFEI_HANDLE_TYPE_AND.equals(handleType)) {
            abstractTiankafeiHandleConditionDTO = new TiankafeiAndHandleConditionDTO();
        } else if (TiankafeiConditionConstants.TIANKAFEI_HANDLE_TYPE_AND.equals(handleType)) {
            abstractTiankafeiHandleConditionDTO = new TiankafeiOrHandleConditionDTO();
        }
        return abstractTiankafeiHandleConditionDTO;
    }

    /**
     * 序列化自定义过滤条件操作抽象对象
     *
     * @param tiankafeiHandleConditionJsonObject 自定义过滤条件操作抽象对象序列化串
     * @return 自定义过滤条件操作抽象对象
     */
    public static AbstractTiankafeiHandleConditionDTO createAbstractTiankafeiHandleConditionDTO(JSONObject tiankafeiHandleConditionJsonObject) {
        AbstractTiankafeiHandleConditionDTO abstractTiankafeiHandleConditionDTO = null;
        String handleType = tiankafeiHandleConditionJsonObject.getString("handleType");
        if (TiankafeiConditionConstants.TIANKAFEI_HANDLE_TYPE_AND.equals(handleType)) {
            abstractTiankafeiHandleConditionDTO = JSON.toJavaObject(tiankafeiHandleConditionJsonObject, TiankafeiAndHandleConditionDTO.class);
        } else if (TiankafeiConditionConstants.TIANKAFEI_HANDLE_TYPE_AND.equals(handleType)) {
            abstractTiankafeiHandleConditionDTO = JSON.toJavaObject(tiankafeiHandleConditionJsonObject, TiankafeiOrHandleConditionDTO.class);
        }
        return abstractTiankafeiHandleConditionDTO;
    }

}
