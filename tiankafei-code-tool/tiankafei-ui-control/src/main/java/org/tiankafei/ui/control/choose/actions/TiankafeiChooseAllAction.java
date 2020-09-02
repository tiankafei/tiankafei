package org.tiankafei.ui.control.choose.actions;

import com.google.common.collect.Lists;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;
import org.tiankafei.base.dto.CodeNameDTO;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiChooseAction;
import org.tiankafei.ui.design.againsui.list.TiankafeiListModel;
import org.tiankafei.ui.design.modelsui.TkfList;

/**
 * 全部选择事件
 *
 * @author 甜咖啡
 */
public class TiankafeiChooseAllAction extends AbstractTiankafeiChooseAction {

    @SuppressWarnings("rawtypes")
    public TiankafeiChooseAllAction(TkfList leftTkfList, TkfList rightTkfList) {
        super(leftTkfList, rightTkfList);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void actionPerformed(ActionEvent e) {
        //右侧已经选中的数据集合(从数据模型中选取)
        List<CodeNameDTO> codeNameDtoList = Lists.newArrayList();
        TiankafeiListModel rightTiankafeiListModel = (TiankafeiListModel) rightTkfList.getModel();
        for (int index = 0, length = rightTiankafeiListModel.size(); index < length; index++) {
            CodeNameDTO CodeNameDTO = (CodeNameDTO) rightTiankafeiListModel.getElementAt(index);
            codeNameDtoList.add(CodeNameDTO);
        }
        //验证数据是否已经存在
        if (checkDataExistsFlag(codeNameDtoList, leftTkfList.getCodeNameDtoList())) {
            rightTkfList.setCodeNameDtoList(codeNameDtoList);
            rightTkfList.initTkfListValue();
        } else {
            JOptionPane.showMessageDialog(null, "你选中的数据已经选中过了！");
        }
    }
}
