package org.tiankafei.ui.design.abstractinterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * 抽象鼠标移动及点击事件事件
 *
 * @author tiankafei
 */
public abstract class AbstractTiankafeiMouseAction implements MouseListener, MouseMotionListener {

    /**
     * 构造抽象鼠标移动及点击事件事件对象
     */
    public AbstractTiankafeiMouseAction() {

    }

    /**
     * 鼠标拖拽事件
     */
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    /**
     * 鼠标移动事件
     */
    @Override
    public void mouseMoved(MouseEvent e) {

    }

    /**
     * 鼠标点击事件，在鼠标释放之后触发
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * 鼠标按下事件
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * 鼠标放开事件
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * 鼠标进入事件
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * 鼠标移出事件
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }


}
