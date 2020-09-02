package org.tiankafei.ui.design.abstractinterface;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 抽象键盘事件
 *
 * @author tiankafei
 */
public abstract class AbstractTiankafeiKeyAction implements KeyListener {

    /**
     * 构造抽象键盘事件对象
     */
    public AbstractTiankafeiKeyAction() {

    }

    /**
     * 字符输入事件
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 键盘按下事件
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * 键盘放开事件
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

}
