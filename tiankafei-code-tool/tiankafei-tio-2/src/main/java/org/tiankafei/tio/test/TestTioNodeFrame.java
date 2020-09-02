package org.tiankafei.tio.test;

import com.google.common.collect.Lists;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.tio.client.ClientStarter;
import org.tiankafei.tio.common.TioConstants;
import org.tiankafei.tio.server.ServerStarter;
import org.tiankafei.ui.design.againsui.TiankafeiButton;
import org.tiankafei.ui.design.againsui.TiankafeiComboBox;
import org.tiankafei.ui.design.againsui.TiankafeiFrame;
import org.tiankafei.ui.design.againsui.TiankafeiLabel;
import org.tiankafei.ui.design.againsui.TiankafeiPanel;
import org.tiankafei.ui.design.againsui.TiankafeiScrollPane;
import org.tiankafei.ui.design.againsui.TiankafeiTextArea;
import org.tiankafei.ui.design.againsui.TiankafeiTextField;
import org.tiankafei.ui.design.modelsui.TkfButton;
import org.tiankafei.ui.design.modelsui.TkfComboBox;
import org.tiankafei.ui.design.modelsui.TkfLabel;
import org.tiankafei.ui.design.modelsui.TkfPanel;
import org.tiankafei.ui.design.modelsui.TkfScrollPane;
import org.tiankafei.ui.design.modelsui.TkfTextArea;
import org.tiankafei.ui.design.modelsui.TkfTextField;
import org.tio.core.Node;

/**
 * @author 甜咖啡
 */
public class TestTioNodeFrame {

    protected ClientStarter clientStarter = new ClientStarter();

    protected TkfTextArea tkfServerTextArea;
    protected TkfTextArea tkfClientTextArea;

    public static void main(String[] args) {
        TestTioNodeFrame testTioNodeFrame = new TestTioNodeFrame();
        testTioNodeFrame.initFrame();
    }

    protected void initFrame() {
        try {
            TiankafeiFrame tiankafeiFrame = new TiankafeiFrame();
            tiankafeiFrame.setWidth(800);
            tiankafeiFrame.setHeight(600);
            tiankafeiFrame.setTitle("测试自定义窗体");
            tiankafeiFrame.initTiankafeiFrame();

            TkfPanel contentTkfPanel = tiankafeiFrame.getContentTkfPanel();
            contentTkfPanel.setLayout(new BorderLayout());

            TiankafeiPanel tiankafeiTextPanel = new TiankafeiPanel();
            TkfPanel tkfTextPanel = tiankafeiTextPanel.initTiankafeiPanel();
            tkfTextPanel.setLayout(new GridLayout(1, 2));
            contentTkfPanel.add(tkfTextPanel, BorderLayout.CENTER);

            TiankafeiTextArea tiankafeiClentTextArea = new TiankafeiTextArea();
            tkfClientTextArea = tiankafeiClentTextArea.initTiankafeiTextArea();
            TiankafeiScrollPane tiankafeiClientScrollPane = new TiankafeiScrollPane(tkfClientTextArea);
            tiankafeiClientScrollPane.setTitle("客户端消息");
            TkfScrollPane tkfClientScrollPane = tiankafeiClientScrollPane.initTiankafeiScrollPane();
            tkfTextPanel.add(tkfClientScrollPane);

            TiankafeiTextArea tiankafeiServerTextArea = new TiankafeiTextArea();
            tkfServerTextArea = tiankafeiServerTextArea.initTiankafeiTextArea();
            TiankafeiScrollPane tiankafeiServerScrollPane = new TiankafeiScrollPane(tkfServerTextArea);
            tiankafeiServerScrollPane.setTitle("服务器端消息");
            TkfScrollPane tkfServerScrollPane = tiankafeiServerScrollPane.initTiankafeiScrollPane();
            tkfTextPanel.add(tkfServerScrollPane);

            TiankafeiPanel tiankafeiButtonPanel = new TiankafeiPanel();
            TkfPanel tkfButtonPanel = tiankafeiButtonPanel.initTiankafeiPanel();
            tkfButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            contentTkfPanel.add(tkfButtonPanel, BorderLayout.SOUTH);

            TiankafeiButton tiankafeiClearButton = new TiankafeiButton();
            tiankafeiClearButton.setText("清空");
            TkfButton tkfClearButton = tiankafeiClearButton.initTiankafeiButton();
            tkfButtonPanel.add(tkfClearButton);
            tkfClearButton.addActionListener(new ClearActionListener());

            initOperatePanel(contentTkfPanel);
            tiankafeiFrame.setVisible(true);
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    private void initOperatePanel(TkfPanel contentTkfPanel) throws BaseException {
        TiankafeiPanel tiankafeiOperatePanel = new TiankafeiPanel();
        TkfPanel tkfOperatePanel = tiankafeiOperatePanel.initTiankafeiPanel();
        tkfOperatePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        contentTkfPanel.add(tkfOperatePanel, BorderLayout.NORTH);

        TiankafeiLabel tiankafeiPortLabel = new TiankafeiLabel();
        tiankafeiPortLabel.setText("选择启动的端口");
        TkfLabel tkfPortLabel = tiankafeiPortLabel.initTiankafeiLabel();
        tkfOperatePanel.add(tkfPortLabel);
        TiankafeiComboBox tiankafeiPortComboBox = new TiankafeiComboBox(TioConstants.TEST_PORT_ARRAY);
        TkfComboBox tkfPortComboBox = tiankafeiPortComboBox.initTiankafeiComboBox();
        tkfOperatePanel.add(tkfPortComboBox);

        TiankafeiButton tiankafeiStartServerButton = new TiankafeiButton();
        tiankafeiStartServerButton.setText("启动服务端");
        TkfButton tkfStartServerButton = tiankafeiStartServerButton.initTiankafeiButton();
        tkfOperatePanel.add(tkfStartServerButton);
        tkfStartServerButton.addActionListener(new StartServerActionListener(tkfPortComboBox));

        TiankafeiButton tiankafeiStartButton = new TiankafeiButton();
        tiankafeiStartButton.setText("启动客户端");
        TkfButton tkfStartButton = tiankafeiStartButton.initTiankafeiButton();
        tkfOperatePanel.add(tkfStartButton);
        tkfStartButton.addActionListener(new StartClientActionListener());

        TiankafeiTextField tiankafeiMessageTextField = new TiankafeiTextField();
        tiankafeiMessageTextField.setWidth(300);
        TkfTextField tkfMessageTextField = tiankafeiMessageTextField.initTiankafeiTextField();
        tkfOperatePanel.add(tkfMessageTextField);

        TiankafeiButton tiankafeiSendButton = new TiankafeiButton();
        tiankafeiSendButton.setText("发送消息");
        TkfButton tkfSendButton = tiankafeiSendButton.initTiankafeiButton();
        tkfOperatePanel.add(tkfSendButton);
        tkfSendButton.addActionListener(new SendMessageActionListener(tkfMessageTextField));
    }

    class ClearActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            tkfClientTextArea.setText("");
            tkfServerTextArea.setText("");
        }
    }

    class StartServerActionListener implements ActionListener {
        private TkfComboBox tkfPortComboBox;

        public StartServerActionListener(TkfComboBox tkfPortComboBox) {
            this.tkfPortComboBox = tkfPortComboBox;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //启动服务器端
            String ip = TioConstants.DEFAULT_SERVER;
            int port = Integer.valueOf(tkfPortComboBox.getSelectedItem().toString());
            ServerStarter.serverStart(ip, port, tkfServerTextArea);
            JOptionPane.showMessageDialog(null, "启动完成！");
        }
    }

    class StartClientActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String ip = TioConstants.DEFAULT_SERVER;
            List<Node> nodeList = Lists.newArrayList();
            for (int portIndex = 0, portLength = TioConstants.TEST_PORT_ARRAY.length; portIndex < portLength; portIndex++) {
                int port = TioConstants.TEST_PORT_ARRAY[portIndex];
                Node node = new Node(ip, port);
                nodeList.add(node);
            }
            clientStarter.initClientTio(nodeList, tkfClientTextArea);
            JOptionPane.showMessageDialog(null, "启动完成！");
        }
    }

    class SendMessageActionListener implements ActionListener {
        private TkfTextField tkfMessageTextField;

        public SendMessageActionListener(TkfTextField tkfMessageTextField) {
            this.tkfMessageTextField = tkfMessageTextField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String message = tkfMessageTextField.getText().trim();
            try {
                clientStarter.sendGroup(message);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

}
