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
 * 取消选择事件
 *
 * @author 甜咖啡
 */
public class TiankafeiUnChooseAction extends AbstractTiankafeiChooseAction {

    @SuppressWarnings("rawtypes")
    public TiankafeiUnChooseAction(TkfList leftTkfList, TkfList rightTkfList) {
        super(leftTkfList, rightTkfList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int[] selectArray = rightTkfList.getSelectedIndices();
        int selectLength = selectArray.length;
        if (selectArray.length == 0) {
            JOptionPane.showMessageDialog(null, "您还没有选中要取消选择的数据呢！");
            return;
        }
        TiankafeiListModel tiankafeiListModel = (TiankafeiListModel) rightTkfList.getModel();
        List<CodeNameDTO> codeNameDtoList = Lists.newArrayList();
        for (int index = 0; index < selectLength; index++) {
            codeNameDtoList.add((CodeNameDTO) tiankafeiListModel.getElementAt(selectArray[index]));
        }
        for (int index = 0, length = codeNameDtoList.size(); index < length; index++) {
            tiankafeiListModel.removeElement(codeNameDtoList.get(index));
        }
    }
}
