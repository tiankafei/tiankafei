package org.tiankafei.web.common.utils;

import com.ramostear.captcha.core.AnimCaptcha;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.CubicCurve2D;
import java.awt.image.BufferedImage;

/**
 * @author tiankafei
 * @since 1.0
 */
public class DefaultAnimCaptcha extends AnimCaptcha {

    protected String exp;

    public DefaultAnimCaptcha(String exp) {
        this.exp = exp;
    }

    @Override
    protected Color color() {
        return CaptchaUtil.getColor();
    }

    public BufferedImage drawImage(Color[] colors, char[] chars, int index, int[][] bezier) {
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,width,height);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f * nextInt(10)));
        drawOval(g);
        drawLine(g);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f * nextInt(10)));
        g.setStroke(new BasicStroke(1.2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g.setColor(colors[0]);
        CubicCurve2D shape = new CubicCurve2D.Double(bezier[0][0], bezier[0][1], bezier[1][0], bezier[1][1], bezier[2][0], bezier[2][1], bezier[3][0], bezier[3][1]);
        g.draw(shape);

        g.setFont(getFont());
        FontMetrics fontMetrics = g.getFontMetrics();
        int fw = (width/chars.length) - 2;
        int fm = (fw - (int) fontMetrics.getStringBounds("W", g).getWidth()) / 2;

        Color fontColor = color();
        for(int i=0;i< chars.length;i++){
            AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,getAlpha(index,i));
            g.setComposite(alpha);
            g.setColor(fontColor);
            int fY = height - ((height - (int) fontMetrics.getStringBounds(String.valueOf(chars[i]), g).getHeight()) >> 1);  // 文字的纵坐标
            g.drawString(String.valueOf(chars[i]), i * fw + fm + 3, fY - 3);
        }
        g.dispose();
        return image;
    }

    private float getAlpha(int i, int j) {
        int num = i + j;
        float r = (float) 1 / (length - 1);
        float s = length * r;
        return num >= length ? (num * r - s) : num * r;
    }

    @Override
    public char[] text() {
        return exp.toCharArray();
    }
}
