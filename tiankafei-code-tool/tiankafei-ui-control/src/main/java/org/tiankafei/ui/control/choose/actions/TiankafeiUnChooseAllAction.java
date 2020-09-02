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
 * 取消全部事件
 *
 * @author 甜咖啡
 */
public class TiankafeiUnChooseAllAction extends AbstractTiankafeiChooseAction {

    @SuppressWarnings("rawtypes")
    public TiankafeiUnChooseAllAction(TkfList leftTkfList, TkfList rightTkfList) {
        super(leftTkfList, rightTkfList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TiankafeiListModel rightTiankafeiListModel = (TiankafeiListModel) rightTkfList.getModel();
        int length = rightTiankafeiListModel.size();
        if (length == 0) {
            JOptionPane.showMessageDialog(null, "没有要全部取消选择的数据！");
            return;
        }
        List<CodeNameDTO> codeNameDtoList = Lists.newArrayList();
        for (int index = 0; index < length; index++) {
            codeNameDtoList.add((CodeNameDTO) rightTiankafeiListModel.getElementAt(index));
        }
        for (int index = 0; index < length; index++) {
            rightTiankafeiListModel.removeElement(codeNameDtoList.get(index));
        }
    }
}
