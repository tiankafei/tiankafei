package org.tiankafei.ui.design.againsui;

import com.google.common.collect.Lists;
import java.util.List;
import org.tiankafei.base.dto.CodeNameDTO;
import org.tiankafei.ui.design.models.TiankafeiDesignerVO;
import org.tiankafei.ui.design.modelsui.TkfList;

/**
 * 自定义集合面板对象
 *
 * @author tiankafei1
 */
public class TiankafeiList<E> extends TiankafeiDesignerVO {

    /**
     * 自定义集合面板对象
     */
    private TkfList<E> tkfList;

    /**
     * List面板上的数据
     */
    private List<CodeNameDTO> codeNameDtoList;

    /**
     * 构造自定义集合面板对象
     */
    public TiankafeiList() {
        tkfList = new TkfList<E>();
        codeNameDtoList = Lists.newArrayList();
    }

    /**
     * 初始化自定义集合面板对象
     *
     * @return 自定义集合面板对象
     */
    public TkfList<E> initTiankafeiList() {
        tkfList.setCodeNameDtoList(codeNameDtoList);
        tkfList.setTiankafeiModelUiVO(getTiankafeiModelUiVO());
        //设置控件属性
        setComponentParam(tkfList);
        //初始化List面板列表
        tkfList.initTkfListValue();
        return tkfList;
    }

    public List<CodeNameDTO> getCodeNameDtoList() {
        return codeNameDtoList;
    }

    public void setCodeNameDtoList(List<CodeNameDTO> codeNameDtoList) {
        this.codeNameDtoList = codeNameDtoList;
    }
}
