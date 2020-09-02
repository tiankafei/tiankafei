package org.tiankafei.ui.design.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

/**
 * @author tiankafei1
 */
public class KeyStrokeDemo extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel buttonPnl = null;
    private JButton blueBtn, yellowBtn, redBtn;

    public KeyStrokeDemo() {
        super("快捷键测试程序");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buttonPnl = new JPanel();

        blueBtn = new JButton();
        yellowBtn = new JButton();
        redBtn = new JButton();

        Action blueAction = new ColorAction("bule", null, Color.BLUE, blueBtn);
        Action yellowAction = new ColorAction("yellow", null, Color.YELLOW,
                yellowBtn);
        Action redAction = new ColorAction("red", null, Color.RED, redBtn);

        blueBtn.setAction(blueAction);
        yellowBtn.setAction(yellowAction);
        redBtn.setAction(redAction);

        buttonPnl.add(blueBtn);
        buttonPnl.add(yellowBtn);
        buttonPnl.add(redBtn);
        this.getContentPane().add(buttonPnl, BorderLayout.CENTER);

        KeyStroke blueKs = KeyStroke.getKeyStroke("ctrl B");
        KeyStroke yellowKs = KeyStroke.getKeyStroke("ctrl Y");

        // KeyStroke redKs = KeyStroke.getKeyStroke("ctrl R");//定义一个ctrl + r的快捷键
        // KeyStroke redKs = KeyStroke.getKeyStroke(KeyEvent.VK_R,
        // InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK);  
        KeyStroke redKs = KeyStroke.getKeyStroke("ctrl shift R");

        // 以下是另一种实现快捷键定义的方法，与上面注释的代码实现效果是一样的  
        // KeyStroke blueKs = KeyStroke.getKeyStroke(KeyEvent.VK_B,
        // InputEvent.CTRL_MASK);// 定义一个ctrl + b的快捷键  
        // KeyStroke yellowKs = KeyStroke.getKeyStroke(KeyEvent.VK_Y,
        // InputEvent.CTRL_MASK);  
        // KeyStroke redKs = KeyStroke.getKeyStroke(KeyEvent.VK_R,
        // InputEvent.CTRL_MASK);  

        /** 定义一个ctrl + shift + y的快捷键 */
        // KeyStroke testKS = KeyStroke.getKeyStroke(KeyEvent.VK_Y,  
        // InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK);  

        InputMap imap = buttonPnl
                .getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(blueKs, "panel.blue");
        imap.put(yellowKs, "panel.yellow");
        imap.put(redKs, "panel.red");

        ActionMap amap = buttonPnl.getActionMap();
        amap.put("panel.blue", blueAction);
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.red", redAction);
    }

    public class ColorAction extends AbstractAction {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        public ColorAction(String name, Icon icon, Color c, JButton btn) {
            this.putValue(Action.NAME, name);
            this.putValue(Action.SMALL_ICON, icon);
            this.putValue(Action.SHORT_DESCRIPTION,
                    "set panel color to" + name.toLowerCase());
            this.putValue("color", c);
            this.putValue("button", btn);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) this.getValue("color");
            buttonPnl.setBackground(c);

            JButton btn = (JButton) this.getValue("button");
            System.out.println("command:" + btn.getActionCommand());
        }
    }

    public static void main(String[] args) {
        new KeyStrokeDemo().setVisible(true);
    }
}  
