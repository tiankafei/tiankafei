package org.tiankafei.ui.jface.modelsui;

import com.google.common.collect.Lists;
import java.util.List;
import javax.swing.JList;
import org.tiankafei.base.dto.CodeNameDTO;
import org.tiankafei.ui.design.againsui.list.TiankafeiListModel;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义集合面板对象
 *
 * @author tiankafei1
 */
public class TkfJfcList<E> extends JList<E> {

    private static final long serialVersionUID = -3121240457791727033L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * List面板上的数据
     */
    private List<CodeNameDTO> codeNameDtoList;

    /**
     * 构造自定义集合面板对象
     */
    public TkfJfcList() {
        super();
        tiankafeiModelUiVO = new TiankafeiModelUiVO();
        codeNameDtoList = Lists.newArrayList();
    }

    /**
     * 初始化List面板列表
     */
    @SuppressWarnings("unchecked")
    public void initTkfListValue() {
        TiankafeiListModel tiankafeiListModel = new TiankafeiListModel();
        for (int index = 0, length = codeNameDtoList.size(); index < length; index++) {
            CodeNameDTO CodeNameDTO = codeNameDtoList.get(index);
            tiankafeiListModel.addElement(CodeNameDTO);
        }
        setModel(tiankafeiListModel);
    }

    /**
     * 获取自定义控件模型UI对象
     *
     * @return 自定义控件模型UI对象
     */
    public TiankafeiModelUiVO getTiankafeiModelUiVO() {
        return tiankafeiModelUiVO;
    }

    /**
     * 设置自定义控件模型UI对象
     *
     * @param tiankafeiModelUiVO 自定义控件模型UI对象
     */
    public void setTiankafeiModelUiVO(TiankafeiModelUiVO tiankafeiModelUiVO) {
        this.tiankafeiModelUiVO = tiankafeiModelUiVO;
    }

    public List<CodeNameDTO> getCodeNameDtoList() {
        return codeNameDtoList;
    }

    public void setCodeNameDtoList(List<CodeNameDTO> codeNameDtoList) {
        this.codeNameDtoList = codeNameDtoList;
    }
}
