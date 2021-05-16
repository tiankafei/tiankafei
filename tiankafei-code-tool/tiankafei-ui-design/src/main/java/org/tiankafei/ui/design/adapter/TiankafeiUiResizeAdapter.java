package org.tiankafei.ui.design.adapter;

//import com.sun.awt.AWTUtilities;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import org.tiankafei.common.util.LogUtil;

/**
 * 自定义的调整拉伸适配器对象
 *
 * @author tiankafei
 */
public class TiankafeiUiResizeAdapter extends MouseAdapter {

    private JFrame frame;

    /**
     * 是否位于左上角调整窗口状态
     */
    private boolean isTopLeft;
    /**
     * 是否位于上边界调整窗口状态
     */
    private boolean isTop;
    /**
     * 是否位于右上角调整窗口状态
     */
    private boolean isTopRight;
    /**
     * 是否位于右边界调整窗口状态
     */
    private boolean isRight;
    /**
     * 是否位于右下角调整窗口状态
     */
    private boolean isBottomRight;
    /**
     * 是否位于下边界调整窗口状态
     */
    private boolean isBottom;
    /**
     * 是否位于坐下角调整窗口状态
     */
    private boolean isBottomLeft;
    /**
     * 是否位于左边界调整窗口状态
     */
    private boolean isLeft;
    /**
     * 判断是否为调整窗口状态的范围与边界距离
     */
    private int resizeWidth = 5;
    /**
     * 窗口的最小宽度
     */
    private int minWidth = 230;
    /**
     * 窗口的最小高度
     */
    private int minHeight = 530;

    /**
     * 构造自己的调正适配器对象
     *
     * @param tiankafeiFrame 传入需要调整的窗口对象
     */
    public TiankafeiUiResizeAdapter(JFrame tiankafeiFrame) {
        this.frame = tiankafeiFrame;
    }

    /**
     * 鼠标拖拽处理方法
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();
        int nextx = frame.getX();
        int nexty = frame.getY();

        int nextWidth = frameWidth;
        int nextHeight = frameHeight;

        if (isTopLeft || isLeft || isBottomLeft) {
            nextx += x;
            nextWidth -= x;
        }

        if (isTopLeft || isTop || isTopRight) {
            nexty += y;
            nextHeight -= y;
        }

        if (isTopRight || isRight || isBottomRight) {
            nextWidth = x;
        }

        if (isBottomLeft || isBottom || isBottomRight) {
            nextHeight = y;
        }

        if (nextWidth <= minWidth) {
            nextWidth = minWidth;
            if (isTopLeft || isLeft || isBottomLeft) {
                nextx = frame.getX() + frameWidth - nextWidth;
            }
        }

        if (nextHeight <= minHeight) {
            nextHeight = minHeight;
            if (isTopLeft || isTop || isTopRight) {
                nexty = frame.getY() + frameHeight - nextHeight;
            }
        }

        frame.setBounds(nextx, nexty, nextWidth, nextHeight);
        /** 设置圆角 */
//        AWTUtilities.setWindowShape(frame, new RoundRectangle2D.Double(0.0D, 0.0D, nextWidth, nextHeight, 15.0D, 15.0D));
        frame.setSize(nextWidth, nextHeight);
    }

    /**
     * 鼠标移出处理方法
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int width = frame.getWidth();
        int height = frame.getHeight();

        int cursorType = Cursor.DEFAULT_CURSOR;
        isTopLeft = isTop = isTopRight = isRight = isBottomRight = isBottom = isBottomLeft = isLeft = false;

        if (y <= resizeWidth) {
            if (x <= resizeWidth) {
                //左上角调整窗口状态
                isTopLeft = true;
                cursorType = Cursor.NW_RESIZE_CURSOR;
                LogUtil.warn("//左上角调整窗口状态");
            } else if (x >= width - resizeWidth) {
                //右上角调整窗口状态
                isTopRight = true;
                cursorType = Cursor.NE_RESIZE_CURSOR;
                LogUtil.warn("//右上角调整窗口状态");
            } else {
                //上边界调整窗口状态
                isTop = true;
                cursorType = Cursor.N_RESIZE_CURSOR;
                LogUtil.warn("//上边界调整窗口状态");
            }
        } else if (y >= height - resizeWidth) {
            //左下角调整窗口状态
            if (x <= resizeWidth) {
                isBottomLeft = true;
                cursorType = Cursor.SW_RESIZE_CURSOR;
                LogUtil.warn("//左下角调整窗口状态");
            } else if (x >= width - resizeWidth) {
                //右下角调整窗口状态
                isBottomRight = true;
                cursorType = Cursor.SE_RESIZE_CURSOR;
                LogUtil.warn("//右下角调整窗口状态");
            } else {
                //下边界调整窗口状态
                isBottom = true;
                cursorType = Cursor.S_RESIZE_CURSOR;
                LogUtil.warn("//下边界调整窗口状态");
            }
        } else if (x <= resizeWidth) {
            //左边界调整窗口状态
            isLeft = true;
            cursorType = Cursor.W_RESIZE_CURSOR;
            LogUtil.warn("//左边界调整窗口状态");
        } else if (x >= width - resizeWidth) {
            isRight = true;
            cursorType = Cursor.E_RESIZE_CURSOR;
            LogUtil.warn("//右边界调整窗口状态");
        }
        frame.setCursor(new Cursor(cursorType));
    }

    /**
     * 获取窗口的最小宽度
     *
     * @return 窗口的最小宽度
     */
    public int getMinWidth() {
        return minWidth;
    }

    /**
     * 设置窗口的最小宽度
     *
     * @param minWidth 窗口的最小宽度
     */
    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    /**
     * 获取窗口的最小高度
     *
     * @return 窗口的最小高度
     */
    public int getMinHeight() {
        return minHeight;
    }

    /**
     * 设置窗口的最小高度
     *
     * @param minHeight 窗口的最小高度
     */
    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

}