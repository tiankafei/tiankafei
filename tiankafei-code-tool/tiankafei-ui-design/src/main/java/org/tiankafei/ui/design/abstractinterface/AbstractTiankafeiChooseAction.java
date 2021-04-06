package org.tiankafei.ui.design.abstractinterface;

import java.util.List;
import org.tiankafei.common.dto.CodeNameDTO;
import org.tiankafei.ui.design.modelsui.TkfList;

/**
 * @author 甜咖啡
 */
public abstract class AbstractTiankafeiChooseAction extends AbstractTiankafeiActionListener {

    @SuppressWarnings("rawtypes")
    protected TkfList leftTkfList;

    @SuppressWarnings("rawtypes")
    protected TkfList rightTkfList;

    @SuppressWarnings("rawtypes")
    public AbstractTiankafeiChooseAction(TkfList leftTkfList, TkfList rightTkfList) {
        this.leftTkfList = leftTkfList;
        this.rightTkfList = rightTkfList;
    }

    /**
     * 验证数据是否已经存在
     *
     * @param codeNameDtoList     存在的数据集合
     * @param tempCodeNameDtoList 要添加的数据集合
     * @return 只要有一个不存在则返回true，否则返回false
     */
    protected boolean checkDataExistsFlag(List<CodeNameDTO> codeNameDtoList, List<CodeNameDTO> tempCodeNameDtoList) {
        boolean flag = false;
        //已经选中的值集合
        for (int index = 0, length = tempCodeNameDtoList.size(); index < length; index++) {
            CodeNameDTO CodeNameDTO = tempCodeNameDtoList.get(index);
            if (!codeNameDtoList.contains(CodeNameDTO)) {
                codeNameDtoList.add(CodeNameDTO);
                flag = true;
            }
        }
        return flag;
    }

}
