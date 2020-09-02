package org.tiankafei.ui.control;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.tiankafei.ui.design.againsui.TiankafeiComboBox;
import org.tiankafei.ui.design.againsui.TiankafeiTextField;
import org.tiankafei.ui.design.modelsui.TkfComboBox;
import org.tiankafei.ui.design.modelsui.TkfTextField;

/**
 * 搜索提示控件
 *
 * @author 甜咖啡
 */
public class TiankafeiSearchPromptControls {

    /**
     * 搜索提示输入框
     */
    private TkfTextField tkfTextField;

    /**
     * 搜索提示下拉框
     */
    @SuppressWarnings("rawtypes")
    private TkfComboBox tkfComboBox;

    /**
     * 搜索内容集合
     */
    private List<String> searchContentList;

    /**
     * 构造搜索提示控件
     *
     * @param searchContentList 要搜搜的内容集合
     * @param controlsWidth     搜索提示输入框宽度
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public TiankafeiSearchPromptControls(List<String> searchContentList, int controlsWidth) {
        this.searchContentList = searchContentList;
        //搜索提示输入框
        TiankafeiTextField tiankafeiTextField = new TiankafeiTextField();
        tiankafeiTextField.setWidth(controlsWidth);
        tkfTextField = tiankafeiTextField.initTiankafeiTextField();
        //搜索提示下拉框
        TiankafeiComboBox tiankafeiComboBox = new TiankafeiComboBox();
        tiankafeiComboBox.setWidth(controlsWidth);
        tiankafeiComboBox.setHeight(0);
        tkfComboBox = tiankafeiComboBox.initTiankafeiComboBox();
        //加载下拉框内容
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        for (int index = 0, length = searchContentList.size(); index < length; index++) {
            defaultComboBoxModel.addElement(searchContentList.get(index));
        }
        tkfComboBox.setModel(defaultComboBoxModel);
        tkfComboBox.setSelectedItem(null);
    }

    /**
     * 初始化搜索提示控件输入框
     *
     * @return 搜索提示控件输入框
     */
    public TkfTextField initTiankafeiSearchPromptControls() {
        setupAutoComplete();

        return tkfTextField;
    }

    /**
     * 设置自动提示
     */
    private void setupAutoComplete() {
        setAdjusting(tkfComboBox, false);
        tkfTextField.setLayout(new BorderLayout(0, 0));
        tkfTextField.add(tkfComboBox, BorderLayout.SOUTH);
        //搜索提示下拉框增加点击事件
        tkfComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isAdjusting(tkfComboBox)) {
                    if (tkfComboBox.getSelectedItem() != null) {
                        tkfTextField.setText(tkfComboBox.getSelectedItem().toString());
                    }
                }
            }
        });
        //搜索提示下拉框增加键盘事件
        tkfTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                setAdjusting(tkfComboBox, true);
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (tkfComboBox.isPopupVisible()) {
                        e.setKeyCode(KeyEvent.VK_ENTER);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    e.setSource(tkfComboBox);
                    tkfComboBox.dispatchEvent(e);
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        if (tkfComboBox.getSelectedItem() != null) {
                            tkfTextField.setText(tkfComboBox.getSelectedItem().toString());
                            tkfComboBox.setPopupVisible(false);
                        }
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    tkfComboBox.setPopupVisible(false);
                }
                setAdjusting(tkfComboBox, false);
            }
        });
        //搜索提示下拉框增加文档事件
        tkfTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateList();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateList();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateList();
            }

            @SuppressWarnings({"rawtypes", "unchecked"})
            private void updateList() {
                DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel) tkfComboBox.getModel();
                setAdjusting(tkfComboBox, true);
                defaultComboBoxModel.removeAllElements();
                String input = tkfTextField.getText();
                if (!input.isEmpty()) {
                    for (int index = 0, length = searchContentList.size(); index < length; index++) {
                        String content = searchContentList.get(index);
                        if (content.toLowerCase().startsWith(input.toLowerCase())) {
                            defaultComboBoxModel.addElement(content);
                        }
                    }
                }
                tkfComboBox.setPopupVisible(defaultComboBoxModel.getSize() > 0);
                setAdjusting(tkfComboBox, false);
            }
        });
    }

    /**
     * 获取下拉框属性值
     *
     * @param tkfComboBox 下拉框对象
     * @return 下拉框属性值
     */
    private boolean isAdjusting(TkfComboBox<?> tkfComboBox) {
        if (tkfComboBox.getTiankafeiModelUiVO().getParamObject() instanceof Boolean) {
            return (Boolean) tkfComboBox.getTiankafeiModelUiVO().getParamObject();
        }
        return false;
    }

    /**
     * 设置下拉框属性值
     *
     * @param tkfComboBox 下拉框对象
     * @param adjusting   下拉框属性值
     */
    private void setAdjusting(TkfComboBox<?> tkfComboBox, boolean adjusting) {
        tkfComboBox.getTiankafeiModelUiVO().setParamObject(adjusting);
    }

}
