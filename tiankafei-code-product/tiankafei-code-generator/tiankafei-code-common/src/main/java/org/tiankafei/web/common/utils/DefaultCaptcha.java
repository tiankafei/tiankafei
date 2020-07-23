package org.tiankafei.web.common.utils;

import com.ramostear.captcha.core.Captcha;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;

/**
 * @author tiankafei
 * @since 1.0
 */
public class DefaultCaptcha extends Captcha {

    protected String exp;

    public DefaultCaptcha(String exp) {
        this.exp = exp;
    }

    @Override
    protected Color color() {
        return CaptchaUtil.getColor();
    }

    public void drawImage(char[] chars, OutputStream output) {
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        Graphics2D g = (Graphics2D)img.getGraphics();
        g.setBackground(Color.WHITE);
        g.fillRect(0,0,width,height);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        drawLine(g);
        drawOval(g);
        drawBezierLine(g);
        g.setFont(getFont());
        FontMetrics fontMetrics = g.getFontMetrics();
        int fw = (width/chars.length) - 2;
        int fm = (fw - (int)fontMetrics.getStringBounds("8",g).getWidth())/2;

        Color fontColor = color();
        for(int i=0;i<chars.length;i++){
            g.setColor(fontColor);
            int fh = height - ((height-(int)fontMetrics.getStringBounds(String.valueOf(chars[i]),g).getHeight()) >> 1);
            g.drawString(String.valueOf(chars[i]),i*fw+fm,fh);
        }
        g.dispose();
        try {
            ImageIO.write(img,"png",output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public char[] text() {
        return exp.toCharArray();
    }
}
