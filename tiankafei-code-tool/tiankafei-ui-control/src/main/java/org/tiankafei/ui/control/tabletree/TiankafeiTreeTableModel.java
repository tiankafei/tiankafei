package org.tiankafei.ui.control.tabletree;

import com.google.common.collect.Lists;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.commons.collections4.CollectionUtils;
import org.tiankafei.ui.control.dto.ConditionColumnDTO;
import org.tiankafei.ui.design.againsui.TiankafeiTreeNode;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.dto.TableColumnDTO;
import org.tiankafei.ui.design.dto.TiankafeiTreeDTO;
import org.tiankafei.ui.design.models.TiankafeiTableAttributeVO;
import org.tiankafei.ui.design.models.TiankafeiTreeAttributeVO;
import org.tiankafei.ui.design.models.TiankafeiTreeNodeAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfTreeNode;

/**
 * 自定义树型表格数据模型
 *
 * @author tiankafei1
 */
public class TiankafeiTreeTableModel extends AbstractTiankafeiTreeTableModel implements ITiankafeiTreeTableModel {

    /**
     * 表格列集合
     */
    private List<TableColumnDTO> tableColumnList;
    /**
     * 表格标题列表
     */
    public List<String> tableHeaderTitleList;
    /**
     * 表格数据
     */
    public List<TiankafeiTreeDTO> treeTableList;
    /**
     * 表格列数据类型的class
     */
    private static Class<?>[] tableColumnDataTypeArray;

    /**
     * 构造自定义树型表格数据模型
     *
     * @param tiankafeiTreeAttributeVO  自定义树属性对象
     * @param tiankafeiTableAttributeVO 自定义表格属性对象
     */
    public TiankafeiTreeTableModel(TiankafeiTreeAttributeVO tiankafeiTreeAttributeVO, TiankafeiTableAttributeVO tiankafeiTableAttributeVO) {
        //表格头部标题集合
        List<String> tableHeaderTitleList = Lists.newArrayList();
        tableColumnList = tiankafeiTableAttributeVO.getTableColumnList();

        TableColumnDTO treeColumnDTO = new TableColumnDTO();
        treeColumnDTO.setHeader("树标题");
        treeColumnDTO.setTableColumnControlsType(TiankafeiDesignerConstants.CHOOSE_TYPE_NO);
        tableColumnList.add(0, treeColumnDTO);
        int tableColumnLength = tableColumnList.size();
        tableColumnDataTypeArray = new Class<?>[tableColumnLength];
        //组装表头数组集合
        for (int tableColumnIndex = 0; tableColumnIndex < tableColumnLength; tableColumnIndex++) {
            TableColumnDTO tableColumnDTO = tableColumnList.get(tableColumnIndex);
            tableHeaderTitleList.add(tableColumnDTO.getHeader());
            if (tableColumnIndex == 0) {
                tableColumnDataTypeArray[0] = ITiankafeiTreeTableModel.class;
            } else {
                tableColumnDataTypeArray[tableColumnIndex] = String.class;
            }
        }
        this.tableHeaderTitleList = tableHeaderTitleList;
        this.treeTableList = tiankafeiTreeAttributeVO.getTreeList();

        //创建树的跟节点对象
        TiankafeiTreeNode rootTiankafeiTreeNode = new TiankafeiTreeNode();
        TiankafeiTreeNodeAttributeVO tiankafeiTreeNodeAttributeVO = rootTiankafeiTreeNode.getTiankafeiTreeNodeAttributeVO();
        tiankafeiTreeNodeAttributeVO.setUserObject(tiankafeiTreeAttributeVO.getTreeTableRootDTO());
        tiankafeiTreeNodeAttributeVO.setExpandPathFlag(true);
        TkfTreeNode rootTkfTreeNode = rootTiankafeiTreeNode.initTiankafeiTreeNode();
        this.setRoot(rootTkfTreeNode);

        //创建子节点
        List<TiankafeiTreeDTO> treeList = tiankafeiTreeAttributeVO.getTreeList();
        createNodes(rootTkfTreeNode, treeList);
    }

    /**
     * 创建节点
     *
     * @param rootTkfTreeNode
     * @param treeList
     */
    private void createNodes(TkfTreeNode rootTkfTreeNode, List<TiankafeiTreeDTO> treeList) {
        if (CollectionUtils.isNotEmpty(treeList)) {
            for (int i = 0, lem = treeList.size(); i < lem; i++) {
                TiankafeiTreeDTO tiankafeiTreeDTO = treeList.get(i);

                TiankafeiTreeNode tiankafeiTreeNode = new TiankafeiTreeNode();
                TiankafeiTreeNodeAttributeVO tiankafeiTreeNodeAttributeVO = tiankafeiTreeNode.getTiankafeiTreeNodeAttributeVO();
                tiankafeiTreeNodeAttributeVO.setUserObject(tiankafeiTreeDTO);
                TkfTreeNode tkfTreeNode = tiankafeiTreeNode.initTiankafeiTreeNode();
                rootTkfTreeNode.add(tkfTreeNode);

                // 子节点集合
                List<TiankafeiTreeDTO> tiankafeiTreeList1 = tiankafeiTreeDTO.getTiankafeiTreeList();
                createNodes(tkfTreeNode, tiankafeiTreeList1);
            }
        }
    }

    @Override
    public Object getValueAt(Object node, int column) {
        DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) node;
        Object userObject = treeNode.getUserObject();
        if (userObject instanceof TiankafeiTreeDTO) {
            TiankafeiTreeDTO tiankafeiTreeDTO = (TiankafeiTreeDTO) userObject;
            if (tiankafeiTreeDTO.getUserObject() instanceof List) {
                if (column == 0) {
                    return tiankafeiTreeDTO.getName();
                } else {
                    List<?> dataList = (List<?>) tiankafeiTreeDTO.getUserObject();
                    Object object = dataList.get(column - 1);
                    if (object instanceof ConditionColumnDTO) {
                        ConditionColumnDTO conditionColumnDTO = (ConditionColumnDTO) object;
                        return conditionColumnDTO.getColumnValue();
                    } else {
                        return "";
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int column) {
        return tableColumnDataTypeArray[column];
    }

    @Override
    public int getColumnCount() {
        return tableHeaderTitleList.size();
    }

    @Override
    public String getColumnName(int column) {
        return tableHeaderTitleList.get(column);
    }

    @Override
    public Object getChild(Object parent, int index) {
        if (parent instanceof DefaultMutableTreeNode) {
            return ((DefaultMutableTreeNode) parent).getChildAt(index);
        } else {
            return null;
        }
    }

    @Override
    public int getChildCount(Object parent) {
        int count = 0;
        if (parent instanceof DefaultMutableTreeNode) {
            count = ((DefaultMutableTreeNode) parent).getChildCount();
        }
        return count;
    }

    @Override
    public boolean isLeaf(Object node) {
        return ((DefaultMutableTreeNode) node).getChildCount() == 0;
    }

}
