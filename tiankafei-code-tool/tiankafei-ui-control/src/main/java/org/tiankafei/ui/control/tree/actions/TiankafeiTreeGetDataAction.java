package org.tiankafei.ui.control.tree.actions;

import java.awt.event.ActionEvent;
import java.util.List;
import org.tiankafei.ui.control.TiankafeiTreeControls;
import org.tiankafei.ui.design.abstractinterface.AbstractTiankafeiActionListener;
import org.tiankafei.ui.design.dto.TiankafeiTreeDTO;

/**
 * @author 甜咖啡
 */
public class TiankafeiTreeGetDataAction extends AbstractTiankafeiActionListener {

    private TiankafeiTreeControls tiankafeiTreeControls;

    public TiankafeiTreeGetDataAction(TiankafeiTreeControls tiankafeiTreeControls) {
        this.tiankafeiTreeControls = tiankafeiTreeControls;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<TiankafeiTreeDTO> tiankafeiTreeDtoList = tiankafeiTreeControls.getChooseNodeList();
        for (int index = 0, length = tiankafeiTreeDtoList.size(); index < length; index++) {
            System.out.println(tiankafeiTreeDtoList.get(index));
        }
    }

}
