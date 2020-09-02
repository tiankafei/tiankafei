package org.tiankafei.ui.design.util;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 自定义拖拽工具类
 * 在初始化该组件的时候调用 setDragable() 就可以使组件具体拖放窗体的功能了。因为可能有背景图，可能会重写paint方法，不能在paint方法中调用setDragable()
 *
 * @author tiankafei1
 */
public class TiankafeiDragableUtil {

    /**
     * 当前位置
     */
    private Point locationPoint = null;

    /**
     * 临时位置
     */
    private Point tempPoint = null;

    /**
     * 鼠标是否处于按下(只有按下才能进行拖拽)
     */
    private boolean isDragged = false;

    /**
     * 要拖拽的窗体
     */
    private JFrame frame;

    /**
     * 窗体上要拖拽的面板
     */
    private JPanel panel;

    /**
     * 构造自定义拖拽工具类对象
     *
     * @param frame 要拖拽的窗体
     * @param panel 窗体上要拖拽的面板
     */
    public TiankafeiDragableUtil(JFrame frame, JPanel panel) {
        this.frame = frame;
        this.panel = panel;
    }

    /**
     * 设置面板可拖拽
     */
    public void setDragable() {
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //鼠标释放
                isDragged = false;
                frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //鼠标按下
                int height = panel.getHeight();
                int width = panel.getWidth();
                int number = 3;
                if (e.getX() < width && e.getX() >= number && e.getY() < height && e.getY() >= number) {
                    tempPoint = new Point(e.getX(), e.getY());
                    isDragged = true;
                    frame.setCursor(new Cursor(Cursor.MOVE_CURSOR));
                }
            }
        });
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //鼠标拖动
                if (isDragged) {
                    locationPoint = new Point(frame.getLocation().x + e.getX() - tempPoint.x, frame.getLocation().y + e.getY() - tempPoint.y);
                    frame.setLocation(locationPoint);
                }
            }
        });
    }
}
