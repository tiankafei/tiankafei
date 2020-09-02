package org.tiankafei.ui.design.againsui.tabbedpane.defaults;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.text.View;
import org.tiankafei.ui.design.models.TiankafeiTabbedAttributeVO;
import org.tiankafei.ui.design.modelsui.TkfTabbedClosedPane;

/**
 * 自定可关闭的标签面板UI
 *
 * @author tiankafei1
 */
public class TiankafeiTabbedClosedPaneUi extends javax.swing.plaf.metal.MetalTabbedPaneUI {

    private Rectangle[] closeRects = new Rectangle[0];
    private int nowIndex = -1;
    private int oldIndex = -1;

    /**
     * 自定义可关闭的标签面板对象
     */
    private TkfTabbedClosedPane tkfTabbedClosedPane;

    /**
     * 标签渐变上方颜色
     */
    private Color tabTopColor;

    /**
     * 标签渐变下方颜色
     */
    private Color tabBottomColor;

    /**
     * 显示关闭图标的标识
     */
    private boolean showClosedFlag;

    /**
     * 标签边框背景色
     */
    private Color tabBorderColor;

    /**
     * 构造自定义可关闭面板UI
     *
     * @param tkfTabbedClosedPane 自定义可关闭的标签面板对象
     */
    public TiankafeiTabbedClosedPaneUi(TkfTabbedClosedPane tkfTabbedClosedPane) {
        this.tkfTabbedClosedPane = tkfTabbedClosedPane;
        //自定义标签面板属性对象
        TiankafeiTabbedAttributeVO tiankafeiTabbedAttributeVO = tkfTabbedClosedPane.getTiankafeiTabbedAttributeVO();
        tabTopColor = tiankafeiTabbedAttributeVO.getTabTopColor();
        tabBottomColor = tiankafeiTabbedAttributeVO.getTabBottomColor();
        showClosedFlag = tiankafeiTabbedAttributeVO.isShowClosedFlag();
        tabBorderColor = tiankafeiTabbedAttributeVO.getTabBorderColor();
        initialize();
    }

    private void initialize() {
        tkfTabbedClosedPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //自定义标签面板属性对象
                TiankafeiTabbedAttributeVO tiankafeiTabbedAttributeVO = tkfTabbedClosedPane.getTiankafeiTabbedAttributeVO();
                Vector<Boolean> closableVector = tiankafeiTabbedAttributeVO.getClosableVector();
                for (int tabIndex = 0, tabLength = tkfTabbedClosedPane.getTabCount(); tabIndex < tabLength; tabIndex++) {
                    if (closeRects[tabIndex].contains(e.getPoint()) && closableVector.get(tabIndex)) {
                        tkfTabbedClosedPane.removeTab(tabIndex);
                    }
                }
            }
        });
        tkfTabbedClosedPane.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                nowIndex = -1;

                //自定义标签面板属性对象
                TiankafeiTabbedAttributeVO tiankafeiTabbedAttributeVO = tkfTabbedClosedPane.getTiankafeiTabbedAttributeVO();
                Vector<Boolean> closableVector = tiankafeiTabbedAttributeVO.getClosableVector();
                int tabLength = tkfTabbedClosedPane.getTabCount();
                for (int tabIndex = 0; tabIndex < tabLength; tabIndex++) {
                    if (closeRects[tabIndex].contains(e.getPoint()) && closableVector.get(tabIndex)) {
                        nowIndex = tabIndex;
                        break;
                    }
                }
                if (oldIndex != nowIndex) {
                    if (nowIndex != -1) {
                        tkfTabbedClosedPane.repaint(closeRects[nowIndex]);
                    } else {
                        if (oldIndex < tabLength) {
                            tkfTabbedClosedPane.repaint(closeRects[oldIndex]);
                        }
                    }
                    oldIndex = nowIndex;
                }
            }
        });
    }

    @Override
    protected void paintContentBorderTopEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        Rectangle selRect = selectedIndex < 0 ? null : getTabBounds(selectedIndex, calcRect);
        g.setColor(tabBorderColor);
        boolean flag = tabPlacement != TOP || selectedIndex < 0 || (selRect.y + selRect.height + 1 < y) || (selRect.x < x || selRect.x > x + w);
        if (flag) {
            g.drawLine(x, y, x + w - 2, y);
        } else {
            g.drawLine(x, y, selRect.x - 1, y);
            int number = 2;
            if (selRect.x + selRect.width < x + w - number) {
                g.drawLine(selRect.x + selRect.width, y, x + w - 2, y);
            } else {
                g.drawLine(x + w - 2, y, x + w - 2, y);
            }
        }
    }

    @Override
    protected void paintContentBorderLeftEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        Rectangle selRect = selectedIndex < 0 ? null : getTabBounds(selectedIndex, calcRect);
        g.setColor(tabBorderColor);
        boolean flag = tabPlacement != LEFT || selectedIndex < 0 || (selRect.x + selRect.width + 1 < x) || (selRect.y < y || selRect.y > y + h);
        if (flag) {
            g.drawLine(x, y, x, y + h - 2);
        } else {
            g.drawLine(x, y, x, selRect.y - 1);
            int number = 2;
            if (selRect.y + selRect.height < y + h - number) {
                g.drawLine(x, selRect.y + selRect.height, x, y + h - 2);
            }
        }
    }

    @Override
    protected void paintContentBorderBottomEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        Rectangle selRect = selectedIndex < 0 ? null : getTabBounds(selectedIndex, calcRect);
        g.setColor(tabBorderColor);
        boolean flag = tabPlacement != BOTTOM || selectedIndex < 0 || (selRect.y - 1 > h) || (selRect.x < x || selRect.x > x + w);
        if (flag) {
            g.drawLine(x, y + h - 1, x + w - 1, y + h - 1);
        } else {
            g.drawLine(x, y + h - 1, selRect.x - 1, y + h - 1);
            int number = 2;
            if (selRect.x + selRect.width < x + w - number) {
                g.drawLine(selRect.x + selRect.width, y + h - 1, x + w - 1, y + h - 1);
            }
        }
    }

    @Override
    protected void paintContentBorderRightEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        Rectangle selRect = selectedIndex < 0 ? null : getTabBounds(selectedIndex, calcRect);
        g.setColor(tabBorderColor);
        boolean flag = tabPlacement != RIGHT || selectedIndex < 0 || (selRect.x - 1 > w) || (selRect.y < y || selRect.y > y + h);
        if (flag) {
            g.drawLine(x + w - 1, y, x + w - 1, y + h - 1);
        } else {
            g.drawLine(x + w - 1, y, x + w - 1, selRect.y - 1);
            int number = 2;
            if (selRect.y + selRect.height < y + h - number) {
                g.drawLine(x + w - 1, selRect.y + selRect.height, x + w - 1, y + h - 2);
            }
        }
    }

    @Override
    protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect) {
        super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);
        //自定义标签面板属性对象
        TiankafeiTabbedAttributeVO tiankafeiTabbedAttributeVO = tkfTabbedClosedPane.getTiankafeiTabbedAttributeVO();
        Vector<Boolean> closableVector = tiankafeiTabbedAttributeVO.getClosableVector();
        boolean flag = closableVector.get(tabIndex) && (showClosedFlag || tabIndex == tkfTabbedClosedPane.getSelectedIndex());
        if (flag) {
            paintCloseIcon(g, tabIndex, tabIndex == nowIndex);
        }
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        g.setColor(tabBorderColor);
        switch (tabPlacement) {
            case LEFT:
                g.drawLine(x, y, x, y + h - 1);
                g.drawLine(x, y, x + w - 1, y);
                g.drawLine(x, y + h - 1, x + w - 1, y + h - 1);
                break;
            case RIGHT:
                g.drawLine(x, y, x + w - 1, y);
                g.drawLine(x, y + h - 1, x + w - 1, y + h - 1);
                g.drawLine(x + w - 1, y, x + w - 1, y + h - 1);
                break;
            case BOTTOM:
                g.drawLine(x, y, x, y + h - 1);
                g.drawLine(x + w - 1, y, x + w - 1, y + h - 1);
                g.drawLine(x, y + h - 1, x + w - 1, y + h - 1);
                break;
            case TOP:
            default:
                g.drawLine(x, y, x, y + h - 1);
                g.drawLine(x, y, x + w - 1, y);
                g.drawLine(x + w - 1, y, x + w - 1, y + h - 1);
        }
    }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {

    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        GradientPaint gradient;
        Graphics2D g2d = (Graphics2D) g;
        switch (tabPlacement) {
            case LEFT:
                if (isSelected) {
                    gradient = new GradientPaint(x + 1, y, Color.WHITE, x + w, y, Color.WHITE, true);
                } else {
                    gradient = new GradientPaint(x + 1, y, tabTopColor, x + w, y, tabBottomColor, true);
                }
                g2d.setPaint(gradient);
                g.fillRect(x + 1, y + 1, w - 1, h - 2);
                break;
            case RIGHT:
                if (isSelected) {
                    gradient = new GradientPaint(x + w, y, Color.WHITE, x + 1, y, Color.WHITE, true);
                } else {
                    gradient = new GradientPaint(x + w, y, tabTopColor, x + 1, y, tabBottomColor, true);
                }
                g2d.setPaint(gradient);
                g.fillRect(x, y + 1, w - 1, h - 2);
                break;
            case BOTTOM:
                if (isSelected) {
                    gradient = new GradientPaint(x + 1, y + h, Color.WHITE, x + 1, y, Color.WHITE, true);
                } else {
                    gradient = new GradientPaint(x + 1, y + h, tabTopColor, x + 1, y, tabBottomColor, true);
                }
                g2d.setPaint(gradient);
                g.fillRect(x + 1, y, w - 2, h - 1);
                break;
            case TOP:
            default:
                if (isSelected) {
                    gradient = new GradientPaint(x + 1, y, Color.WHITE, x + 1, y + h, Color.WHITE, true);
                } else {
                    gradient = new GradientPaint(x + 1, y, tabTopColor, x + 1, y + h, tabBottomColor, true);
                }
                g2d.setPaint(gradient);
                g2d.fillRect(x + 1, y + 1, w - 2, h - 1);
        }
    }

    private void paintCloseIcon(Graphics g, int tabIndex, boolean entered) {
        Rectangle rect = closeRects[tabIndex];
        int x = rect.x;
        int y = rect.y;
        int[] xs = {x, x + 2, x + 4, x + 5, x + 7, x + 9, x + 9, x + 7, x + 7, x + 9, x + 9, x + 7, x + 5, x + 4, x + 2, x, x, x + 2, x + 2, x};
        int[] ys = {y, y, y + 2, y + 2, y, y, y + 2, y + 4, y + 5, y + 7, y + 9, y + 9, y + 7, y + 7, y + 9, y + 9, y + 7, y + 5, y + 4, y + 2};
        if (entered) {
            g.setColor(new Color(252, 160, 160));
        } else {
            g.setColor(Color.WHITE);
        }
        g.fillPolygon(xs, ys, 20);
        g.setColor(Color.DARK_GRAY);
        g.drawPolygon(xs, ys, 20);
    }

    @Override
    protected void layoutLabel(int tabPlacement, FontMetrics metrics, int tabIndex, String title, Icon icon, Rectangle tabRect, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
        textRect.x = textRect.y = iconRect.x = iconRect.y = 0;
        View v = getTextViewForTab(tabIndex);
        if (v != null) {
            tabPane.putClientProperty("html", v);
        }
        SwingUtilities.layoutCompoundLabel(
                tabPane,
                metrics, title, icon,
                SwingConstants.CENTER,
                SwingConstants.CENTER,
                SwingConstants.CENTER,
                SwingConstants.TRAILING,
                tabRect, iconRect, textRect, textIconGap);
        tabPane.putClientProperty("html", null);
    }

    @Override
    protected LayoutManager createLayoutManager() {
        return new TabbedPaneLayout();
    }

    @Override
    protected void assureRectsCreated(int tabCount) {
        super.assureRectsCreated(tabCount);
        int rectArrayLen = closeRects.length;
        if (tabCount != rectArrayLen) {
            Rectangle[] tempRectArray = new Rectangle[tabCount];
            System.arraycopy(closeRects, 0, tempRectArray, 0, Math.min(rectArrayLen, tabCount));
            closeRects = tempRectArray;
            for (int rectIndex = rectArrayLen; rectIndex < tabCount; rectIndex++) {
                closeRects[rectIndex] = new Rectangle();
            }
        }
    }

    class TabbedPaneLayout extends BasicTabbedPaneUI.TabbedPaneLayout {
        @Override
        protected void calculateTabRects(int tabPlacement, int tabCount) {
            FontMetrics metrics = getFontMetrics();
            Dimension size = tabPane.getSize();
            Insets insets = tabPane.getInsets();
            Insets tabAreaInsets = getTabAreaInsets(tabPlacement);
            int fontHeight = metrics.getHeight();
            int selectedIndex = tabPane.getSelectedIndex();
            int tabRunOverlay;
            int i, j;
            int x, y;
            int returnAt;
            boolean verticalTabRuns = (tabPlacement == LEFT || tabPlacement == RIGHT);

            switch (tabPlacement) {
                case LEFT:
                    maxTabWidth = calculateMaxTabWidth(tabPlacement) + 20;
                    x = insets.left + tabAreaInsets.left;
                    y = insets.top + tabAreaInsets.top;
                    returnAt = size.height - (insets.bottom + tabAreaInsets.bottom);
                    break;
                case RIGHT:
                    maxTabWidth = calculateMaxTabWidth(tabPlacement) + 20;
                    x = size.width - insets.right - tabAreaInsets.right - maxTabWidth;
                    y = insets.top + tabAreaInsets.top;
                    returnAt = size.height - (insets.bottom + tabAreaInsets.bottom);
                    break;
                case BOTTOM:
                    maxTabHeight = calculateMaxTabHeight(tabPlacement);
                    x = insets.left + tabAreaInsets.left;
                    y = size.height - insets.bottom - tabAreaInsets.bottom - maxTabHeight;
                    returnAt = size.width - (insets.right + tabAreaInsets.right);
                    break;
                case TOP:
                default:
                    maxTabHeight = calculateMaxTabHeight(tabPlacement);
                    x = insets.left + tabAreaInsets.left;
                    y = insets.top + tabAreaInsets.top;
                    returnAt = size.width - (insets.right + tabAreaInsets.right);
                    break;
            }

            tabRunOverlay = getTabRunOverlay(tabPlacement);
            runCount = 0;
            selectedRun = -1;
            if (tabCount == 0) {
                return;
            }
            selectedRun = 0;
            runCount = 1;
            Rectangle rect;
            for (i = 0; i < tabCount; i++) {
                rect = rects[i];
                if (!verticalTabRuns) {
                    if (i > 0) {
                        rect.x = rects[i - 1].x + rects[i - 1].width;
                    } else {
                        tabRuns[0] = 0;
                        runCount = 1;
                        maxTabWidth = 0;
                        rect.x = x;
                    }
                    rect.width = calculateTabWidth(tabPlacement, i, metrics) + 20;
                    maxTabWidth = Math.max(maxTabWidth, rect.width);
                    if (rect.x != 2 + insets.left && rect.x + rect.width > returnAt) {
                        if (runCount > tabRuns.length - 1) {
                            expandTabRunsArray();
                        }
                        tabRuns[runCount] = i;
                        runCount++;
                        rect.x = x;
                    }
                    rect.y = y;
                    rect.height = maxTabHeight;
                } else {
                    if (i > 0) {
                        rect.y = rects[i - 1].y + rects[i - 1].height;
                    } else {
                        tabRuns[0] = 0;
                        runCount = 1;
                        maxTabHeight = 0;
                        rect.y = y;
                    }
                    rect.height = calculateTabHeight(tabPlacement, i, fontHeight);
                    maxTabHeight = Math.max(maxTabHeight, rect.height);
                    if (rect.y != 2 + insets.top && rect.y + rect.height > returnAt) {
                        if (runCount > tabRuns.length - 1) {
                            expandTabRunsArray();
                        }
                        tabRuns[runCount] = i;
                        runCount++;
                        rect.y = y;
                    }
                    rect.x = x;
                    rect.width = maxTabWidth;
                }
                if (i == selectedIndex) {
                    selectedRun = runCount - 1;
                }
            }
            if (runCount > 1) {
                normalizeTabRuns(tabPlacement, tabCount, verticalTabRuns ? y : x, returnAt);
                selectedRun = getRunForTab(tabCount, selectedIndex);
                if (shouldRotateTabRuns(tabPlacement)) {
                    rotateTabRuns(tabPlacement, selectedRun);
                }
            }
            for (i = runCount - 1; i >= 0; i--) {
                int start = tabRuns[i];
                int next = tabRuns[i == (runCount - 1) ? 0 : i + 1];
                int end = (next != 0 ? next - 1 : tabCount - 1);
                if (!verticalTabRuns) {
                    for (j = start; j <= end; j++) {
                        rect = rects[j];
                        rect.y = y;
                        rect.x += getTabRunIndent(tabPlacement, i);
                    }
                    if (shouldPadTabRun(tabPlacement, i)) {
                        padTabRun(tabPlacement, start, end, returnAt);
                    }
                    if (tabPlacement == BOTTOM) {
                        y -= (maxTabHeight - tabRunOverlay);
                    } else {
                        y += (maxTabHeight - tabRunOverlay);
                    }
                } else {
                    for (j = start; j <= end; j++) {
                        rect = rects[j];
                        rect.x = x;
                        rect.y += getTabRunIndent(tabPlacement, i);
                    }
                    if (shouldPadTabRun(tabPlacement, i)) {
                        padTabRun(tabPlacement, start, end, returnAt);
                    }
                    if (tabPlacement == RIGHT) {
                        x -= (maxTabWidth - tabRunOverlay);
                    } else {
                        x += (maxTabWidth - tabRunOverlay);
                    }
                }
            }
            for (i = 0; i < tabCount; i++) {
                closeRects[i].x = rects[i].x + rects[i].width - 14;
                closeRects[i].y = rects[i].y + 6;
                closeRects[i].width = 10;
                closeRects[i].height = 10;
            }
        }
    }

}
