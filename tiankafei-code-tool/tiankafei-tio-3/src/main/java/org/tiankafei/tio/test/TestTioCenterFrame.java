package org.tiankafei.tio.test;

import com.google.common.collect.Lists;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.tio.client.ClientStarter;
import org.tiankafei.tio.common.TioConstants;
import org.tiankafei.ui.design.againsui.TiankafeiButton;
import org.tiankafei.ui.design.againsui.TiankafeiComboBox;
import org.tiankafei.ui.design.againsui.TiankafeiFrame;
import org.tiankafei.ui.design.againsui.TiankafeiLabel;
import org.tiankafei.ui.design.againsui.TiankafeiPanel;
import org.tiankafei.ui.design.againsui.TiankafeiScrollPane;
import org.tiankafei.ui.design.againsui.TiankafeiTextArea;
import org.tiankafei.ui.design.modelsui.TkfButton;
import org.tiankafei.ui.design.modelsui.TkfComboBox;
import org.tiankafei.ui.design.modelsui.TkfLabel;
import org.tiankafei.ui.design.modelsui.TkfPanel;
import org.tiankafei.ui.design.modelsui.TkfScrollPane;
import org.tiankafei.ui.design.modelsui.TkfTextArea;
import org.tio.core.ChannelContext;
import org.tio.core.Node;
import org.tio.core.Tio;
import org.tio.utils.lock.SetWithLock;

/**
 * @author 甜咖啡
 */
public class TestTioCenterFrame {

    protected ClientStarter clientStarter = new ClientStarter();

    protected TkfTextArea tkfServerTextArea;
    protected TkfTextArea tkfClientTextArea;

    public static void main(String[] args) {
        TestTioCenterFrame testTioCenterFrame = new TestTioCenterFrame();
        testTioCenterFrame.initFrame();
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
            tiankafeiClientScrollPane.setTitle("客户端(中心节点)消息");
            TkfScrollPane tkfClientScrollPane = tiankafeiClientScrollPane.initTiankafeiScrollPane();
            tkfTextPanel.add(tkfClientScrollPane);

            TiankafeiTextArea tiankafeiServerTextArea = new TiankafeiTextArea();
            tkfServerTextArea = tiankafeiServerTextArea.initTiankafeiTextArea();
            TiankafeiScrollPane tiankafeiServerScrollPane = new TiankafeiScrollPane(tkfServerTextArea);
            tiankafeiServerScrollPane.setTitle("服务器端(节点)消息");
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

            TiankafeiPanel tiankafeiOperatePanel = new TiankafeiPanel();
            TkfPanel tkfOperatePanel = tiankafeiOperatePanel.initTiankafeiPanel();
            tkfOperatePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            contentTkfPanel.add(tkfOperatePanel, BorderLayout.NORTH);

            TiankafeiButton tiankafeiStartButton = new TiankafeiButton();
            tiankafeiStartButton.setText("启动中心节点");
            TkfButton tkfStartButton = tiankafeiStartButton.initTiankafeiButton();
            tkfOperatePanel.add(tkfStartButton);
            tkfStartButton.addActionListener(new StartCenterActionListener());

            TiankafeiLabel tiankafeiPortLabel = new TiankafeiLabel();
            tiankafeiPortLabel.setText("选择要发送数据的端口");
            TkfLabel tkfPortLabel = tiankafeiPortLabel.initTiankafeiLabel();
            tkfOperatePanel.add(tkfPortLabel);
            TiankafeiComboBox tiankafeiPortComboBox = new TiankafeiComboBox(TioConstants.TEST_PORT_ARRAY);
            TkfComboBox tkfPortComboBox = tiankafeiPortComboBox.initTiankafeiComboBox();
            tkfOperatePanel.add(tkfPortComboBox);

            TiankafeiButton tiankafeiSendButton = new TiankafeiButton();
            tiankafeiSendButton.setText("发送消息");
            TkfButton tkfSendButton = tiankafeiSendButton.initTiankafeiButton();
            tkfOperatePanel.add(tkfSendButton);
            tkfSendButton.addActionListener(new SendMessageActionListener(tkfPortComboBox));
            tiankafeiFrame.setVisible(true);
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    class ClearActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            tkfClientTextArea.setText("");
            tkfServerTextArea.setText("");
        }
    }

    class StartCenterActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String ip = TioConstants.DEFAULT_SERVER;

            List<Node> nodeList = Lists.newArrayList();
            for (int portIndex = 0, portLength = TioConstants.TEST_PORT_ARRAY.length; portIndex < 1; portIndex++) {
                int port = TioConstants.TEST_PORT_ARRAY[portIndex];
                Node node = new Node(ip, port);
                nodeList.add(node);
            }
            clientStarter.initClientTio(nodeList, tkfClientTextArea);
            JOptionPane.showMessageDialog(null, "启动完成！");
        }
    }

    class SendMessageActionListener implements ActionListener {
        private TkfComboBox tkfPortComboBox;

        public SendMessageActionListener(TkfComboBox tkfPortComboBox) {
            this.tkfPortComboBox = tkfPortComboBox;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String ip = TioConstants.DEFAULT_SERVER;
            int port = Integer.valueOf(tkfPortComboBox.getSelectedItem().toString());

            ChannelContext sendChannelContext = null;
            SetWithLock<ChannelContext> setWithLock = Tio.getAllChannelContexts(clientStarter.getClientGroupContext());
            Set<ChannelContext> set1 = setWithLock.getObj();
            for (ChannelContext channelContext : set1) {
                Node node = channelContext.getServerNode();
                if (port == node.getPort() && ip.equals(node.getIp())) {
                    sendChannelContext = channelContext;
                }
            }
            if (sendChannelContext != null) {
                List<String> messageList = Lists.newArrayList();
                messageList.add("发送消息1");
                messageList.add("发送消息2");
                messageList.add("发送消息3");
                messageList.add("发送消息4");
                messageList.add("发送消息5");
                messageList.add("发送消息6");

                //单线程循环发送消息
                for (int index = 0; index < messageList.size(); index++) {
                    String message = messageList.get(index);
                    clientStarter.send(sendChannelContext, message);
                }
            }
        }
    }

}
