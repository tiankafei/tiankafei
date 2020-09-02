package org.tiankafei.ui.control;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.design.againsui.TiankafeiDialog;
import org.tiankafei.ui.design.againsui.TiankafeiFrame;
import org.tiankafei.ui.design.againsui.TiankafeiLabel;
import org.tiankafei.ui.design.againsui.TiankafeiPanel;
import org.tiankafei.ui.design.againsui.TiankafeiTextField;
import org.tiankafei.ui.design.models.TiankafeiCustomInputVO;
import org.tiankafei.ui.design.modelsui.TkfDialog;
import org.tiankafei.ui.design.modelsui.TkfLabel;
import org.tiankafei.ui.design.modelsui.TkfPanel;
import org.tiankafei.ui.design.modelsui.TkfTextField;

/**
 * 自定义输入控件
 *
 * @author 甜咖啡
 */
public class TiankafeiCustomInputControls {

    private TiankafeiFrame tiankafeiFrame;

    /**
     * 自定义面板
     */
    private TkfDialog tkfDialog;

    /**
     * 文本输入框
     */
    private TkfTextField tkfTextField;

    private TkfLabel tkfLabel;

    private TiankafeiCustomInputVO tiankafeiCustomInputVO;

    public TiankafeiCustomInputControls(TiankafeiFrame tiankafeiFrame) throws BaseException {
        this.tiankafeiFrame = tiankafeiFrame;
        tiankafeiCustomInputVO = new TiankafeiCustomInputVO();

        TiankafeiDialog tiankafeiDialog = new TiankafeiDialog();
        tkfDialog = tiankafeiDialog.initTiankafeiDialog();
        tkfDialog.setUndecorated(true);
        tkfDialog.setAlwaysOnTop(true);

        TiankafeiPanel tiankafeiPanel = new TiankafeiPanel();
        tiankafeiPanel.setTopBorderWidth(1);
        tiankafeiPanel.setLeftBorderWidth(1);
        tiankafeiPanel.setRightBorderWidth(1);
        tiankafeiPanel.setBottomBorderWidth(1);
        tiankafeiPanel.setBorderColor(Color.BLACK);
        TkfPanel tkfPanel = tiankafeiPanel.initTiankafeiPanel();
        tkfDialog.add(tkfPanel);
        tkfDialog.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                tkfDialog.setVisible(false);
            }
        });

        tiankafeiFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                tkfDialog.setAlwaysOnTop(true);
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                tkfDialog.setAlwaysOnTop(false);
            }
        });
        tiankafeiFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                tkfDialog.setVisible(false);
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                tkfDialog.setVisible(false);
            }
        });
    }

    public TkfPanel initTiankafeiCustomInputControls() throws BaseException {
        TiankafeiPanel tiankafeiPanel = new TiankafeiPanel();
        tiankafeiPanel.setWidth(tiankafeiCustomInputVO.getCustomInputWidth() + tiankafeiCustomInputVO.getIconInputWidth());
        tiankafeiPanel.setHeight(tiankafeiCustomInputVO.getCustonInputHeight());
        TkfPanel tkfPanel = tiankafeiPanel.initTiankafeiPanel();
        tkfPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        TiankafeiTextField tiankafeiTextField = new TiankafeiTextField();
        tiankafeiTextField.setTopBorderWidth(1);
        tiankafeiTextField.setLeftBorderWidth(1);
        tiankafeiTextField.setRightBorderWidth(0);
        tiankafeiTextField.setBottomBorderWidth(1);
        tiankafeiTextField.setBorderColor(Color.BLACK);
        tiankafeiTextField.setWidth(tiankafeiCustomInputVO.getCustomInputWidth());
        tiankafeiTextField.setHeight(tiankafeiCustomInputVO.getCustonInputHeight());
        tkfTextField = tiankafeiTextField.initTiankafeiTextField();
        tkfPanel.add(tkfTextField);
        tkfTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int number = 2;
                if (number == e.getClickCount()) {
                    initCustomPanel();
                }
            }
        });
        tkfTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = tkfTextField.getText();
                if (StringUtils.isNotEmpty(text)) {
                    initCustomPanel();
                    tkfTextField.requestFocus();
                } else {
                    tkfDialog.setVisible(false);
                }
            }
        });

        TiankafeiLabel tiankafeiLabel = new TiankafeiLabel();
        tiankafeiLabel.setTopBorderWidth(1);
        tiankafeiLabel.setLeftBorderWidth(0);
        tiankafeiLabel.setRightBorderWidth(1);
        tiankafeiLabel.setBottomBorderWidth(1);
        tiankafeiLabel.setBorderColor(Color.BLACK);
        tiankafeiLabel.setWidth(tiankafeiCustomInputVO.getIconInputWidth());
        tiankafeiLabel.setHeight(tiankafeiCustomInputVO.getCustonInputHeight());
        tiankafeiLabel.setIconFilePath(tiankafeiCustomInputVO.getIconFilePath());
        tiankafeiLabel.setIconWidth(tiankafeiCustomInputVO.getIconWidth());
        tiankafeiLabel.setIconHeight(tiankafeiCustomInputVO.getIconHeight());
        tiankafeiLabel.setMouseEnteredChangeFlag(true);
        tkfLabel = tiankafeiLabel.initTiankafeiLabel();
        tkfPanel.add(tkfLabel);
        tkfLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                initCustomPanel();
            }
        });

        return tkfPanel;
    }

    /**
     * 初始化自定义面板
     */
    public void initCustomPanel() {
        Point windowPoint = tiankafeiFrame.getLocation();
        Point textFieldPoint = tkfTextField.getLocation();
        int x = textFieldPoint.x + windowPoint.x + tkfTextField.getInsets().left;
        int y = (int) (textFieldPoint.y + windowPoint.y + tkfTextField.getInsets().top + tkfTextField.getPreferredSize().getHeight());
        Point point = new Point(x, y);
        tkfDialog.setLocation(point);

        int controlsWidth = (int) (tkfTextField.getPreferredSize().getWidth() + tkfLabel.getPreferredSize().getWidth());
        Dimension dimension = new Dimension(controlsWidth, 100);
        tkfDialog.setSize(dimension);
        if (!tkfDialog.isVisible()) {
            tkfDialog.setVisible(true);
        }
    }

}
