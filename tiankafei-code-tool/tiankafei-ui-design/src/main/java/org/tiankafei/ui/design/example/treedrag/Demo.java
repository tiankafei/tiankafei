package org.tiankafei.ui.design.example.treedrag;

import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * <p>
 * Title: JTree之间的拖拽测试
 * </p>
 * <p>
 * Description:通过向从“源树”中拖拽结点在目标树中重新构造一棵树，实现JTree之间的拖拽单向拖拽，这个类测试的类
 * </p>
 *
 * @author awaysrain(绝对零度)
 */
public class Demo extends JFrame {

    private static final long serialVersionUID = 186867756677713395L;
    JPanel contentPane;
    JScrollPane jScrollPane1 = new JScrollPane();
    DragSourceTree jTree1 = new DragSourceTree();
    JScrollPane jScrollPane2 = new JScrollPane();
    DragTargetTree jTree2 = new DragTargetTree();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();

    public static void main(String[] args) {

        Demo demo = new Demo();
        demo.setVisible(true);
    }

    public Demo() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        this.setSize(new Dimension(400, 300));
        this.setTitle("Demo");
        jLabel1.setFont(new java.awt.Font("DialogInput", 0, 16));
        jLabel1.setText("源树");
        jLabel2.setEnabled(true);
        jLabel2.setFont(new java.awt.Font("DialogInput", 0, 16));
        jLabel2.setDebugGraphicsOptions(0);
        jLabel2.setDoubleBuffered(false);
        jLabel2.setVerifyInputWhenFocusTarget(true);
        jLabel2.setDisplayedMnemonic('0');
        jLabel2.setText("目标树");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        contentPane.add(jLabel1);
        contentPane.add(jLabel2);
        contentPane.add(jScrollPane2);
        contentPane.add(jScrollPane1);
        jScrollPane1.getViewport().add(jTree1, null);
        jScrollPane2.getViewport().add(jTree2, null);
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }
}
