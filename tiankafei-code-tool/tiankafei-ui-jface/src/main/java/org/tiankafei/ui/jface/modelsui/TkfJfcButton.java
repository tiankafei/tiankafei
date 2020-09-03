package org.tiankafei.ui.jface.modelsui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import org.tiankafei.ui.design.models.TiankafeiButtonAttributeDTO;
import org.tiankafei.ui.design.models.TiankafeiModelUiVO;

/**
 * 自定义按钮对象
 *
 * @author tiankafei
 */
public class TkfJfcButton extends JButton {

    private static final long serialVersionUID = -6435731776033649257L;

    /**
     * 自定义控件模型UI对象
     */
    private TiankafeiModelUiVO tiankafeiModelUiVO;

    /**
     * 自定义按钮属性对象
     */
    private TiankafeiButtonAttributeDTO tiankafeiButtonAttributeDTO;

    /**
     * 构造自定义按钮对象
     */
    public TkfJfcButton() {
        super();
        tiankafeiModelUiVO = new TiankafeiModelUiVO();
        tiankafeiButtonAttributeDTO = new TiankafeiButtonAttributeDTO();
    }

    /**
     * 重绘按钮
     */
    public void paintcolor() {
        setMargin(new Insets(0, 0, 0, 0));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                tiankafeiButtonAttributeDTO.setHover(true);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                tiankafeiButtonAttributeDTO.setHover(false);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g.create();
        int height = getHeight();
        int with = getWidth();
        float tran = 1F;
        if (!tiankafeiButtonAttributeDTO.isHover()) {
            /* 鼠标离开/进入时的透明度改变量 */
            tran = 0.6F;
        }
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradientPaint1 = null;
        GradientPaint gradientPaint2 = null;
        if (getModel().isPressed()) {
            gradientPaint1 = new GradientPaint(0, 0, new Color(0, 0, 0), 0, height, new Color(100, 100, 100), true);
            gradientPaint2 = new GradientPaint(0, 1, new Color(0, 0, 0, 50), 0, height, new Color(255, 255, 255, 100), true);
        } else {
            gradientPaint1 = new GradientPaint(0, 0, new Color(100, 100, 100), 0, height, new Color(0, 0, 0), true);
            gradientPaint2 = new GradientPaint(0, 1, new Color(255, 255, 255, 100), 0, height, new Color(0, 0, 0, 50), true);
        }
        graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, tran));
        RoundRectangle2D.Float roundRectangle2d = new RoundRectangle2D.Float(0, 0, with - 1, height - 1, tiankafeiButtonAttributeDTO.getRadius(), tiankafeiButtonAttributeDTO.getRadius());
        graphics2d.clip(roundRectangle2d);

        // 最后两个参数数值越大，按钮越圆，以下同理
        GradientPaint gradientPaint = new GradientPaint(0.0F, 0.0F, tiankafeiButtonAttributeDTO.getChangeColor(), 0.0F, height / 2, tiankafeiButtonAttributeDTO.getDefaultColor(), true);
        graphics2d.setPaint(gradientPaint);
        graphics2d.fillRect(0, 0, with, height);

        Shape clip = graphics2d.getClip();
        graphics2d.setClip(clip);

        graphics2d.setPaint(gradientPaint1);
        graphics2d.drawRoundRect(0, 0, with - 3, height - 3, tiankafeiButtonAttributeDTO.getRadius(), tiankafeiButtonAttributeDTO.getRadius());

        graphics2d.setPaint(gradientPaint2);
        graphics2d.drawRoundRect(1, 1, with - 3, height - 3, tiankafeiButtonAttributeDTO.getRadius(), tiankafeiButtonAttributeDTO.getRadius());

        graphics2d.dispose();
        super.paintComponent(g);
    }

    /**
     * 获取自定义控件模型UI对象
     *
     * @return 自定义控件模型UI对象
     */
    public TiankafeiModelUiVO getTiankafeiModelUiVO() {
        return tiankafeiModelUiVO;
    }

    /**
     * 设置自定义控件模型UI对象
     *
     * @param tiankafeiModelUiVO 自定义控件模型UI对象
     */
    public void setTiankafeiModelUiVO(TiankafeiModelUiVO tiankafeiModelUiVO) {
        this.tiankafeiModelUiVO = tiankafeiModelUiVO;
    }

    /**
     * 获取自定义按钮属性对象
     *
     * @return 自定义按钮属性对象
     */
    public TiankafeiButtonAttributeDTO getTiankafeiButtonAttributeDTO() {
        return tiankafeiButtonAttributeDTO;
    }

    /**
     * 设置自定义按钮属性对象
     *
     * @param tiankafeiButtonAttributeDTO 自定义按钮属性对象
     */
    public void setTiankafeiButtonAttributeDTO(TiankafeiButtonAttributeDTO tiankafeiButtonAttributeDTO) {
        this.tiankafeiButtonAttributeDTO = tiankafeiButtonAttributeDTO;
    }

}