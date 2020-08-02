package org.tiankafei.web.common.service.impl;

import com.ramostear.captcha.common.Fonts;
import com.ramostear.captcha.core.AnimCaptcha;
import com.ramostear.captcha.core.Captcha;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.CubicCurve2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Service;
import org.tiankafei.web.common.enums.CaptchaEnum;
import org.tiankafei.web.common.enums.CaptchaTypeEnum;
import org.tiankafei.web.common.exception.VerificationException;
import org.tiankafei.web.common.param.CaptchaVo;
import org.tiankafei.web.common.service.CaptchaGenerateService;

/**
 * @author tiankafei
 * @since 1.0
 */
@Service
public class GenerateHappyCaptchaService implements CaptchaGenerateService {

    @Override
    public CaptchaEnum getCaptchaType() {
        return CaptchaEnum.HAPPY_CAPTCHA;
    }

    @Override
    public String buildImage(OutputStream outputStream, int width, int height, int length, CaptchaTypeEnum captchaTypeEnum) throws VerificationException {
        String captchaCode = DefaultHappyCaptcha
                .require(outputStream)
                .setWidth(width)
                .setHeight(height)
                .setLength(length)
                .setType(CommonCaptchaUtil.getCaptchaType(captchaTypeEnum))
                .builder()
                .finish();
        return captchaCode;
    }

    static class DefaultHappyCaptcha {

        private CaptchaType type;
        private CaptchaStyle style;
        private Font font;
        private int width;
        private int height;
        private int length;
        private OutputStream outputStream;

        public static Builder require(OutputStream outputStream) {
            return new Builder(outputStream);
        }

        public String finish() {
            try {
                CaptchaVo captchaVo = CommonCaptchaUtil.getCaptcha(this.type);
                if (this.style.equals(CaptchaStyle.IMG)) {
                    DefaultCaptcha captcha = new DefaultCaptcha(captchaVo.getExpression());
                    captcha.setType(this.type);
                    captcha.setWidth(this.width);
                    captcha.setHeight(this.height);
                    captcha.setLength(this.length);
                    captcha.setFont(this.font);
                    captcha.render(this.outputStream);
                    return captchaVo.getCaptcha();
                } else if (this.style.equals(CaptchaStyle.ANIM)) {
                    DefaultAnimCaptcha captcha = new DefaultAnimCaptcha(captchaVo.getExpression());
                    captcha.setType(this.type);
                    captcha.setWidth(this.width);
                    captcha.setHeight(this.height);
                    captcha.setLength(this.length);
                    captcha.setFont(this.font);
                    captcha.render(this.outputStream);
                    return captchaVo.getCaptcha();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        private DefaultHappyCaptcha(Builder builder) {
            this.type = builder.type;
            this.style = builder.style;
            this.font = builder.font;
            this.width = builder.width;
            this.height = builder.height;
            this.length = builder.length;
            this.outputStream = builder.outputStream;
        }
    }

    @Data
    @Accessors(chain = true)
    static class Builder {

        private CaptchaType type = CaptchaType.DEFAULT;
        private CaptchaStyle style = CaptchaStyle.IMG;
        private Font font = Fonts.getInstance().zhFont();
        private int width = 160;
        private int height = 50;
        private int length = 5;
        private final OutputStream outputStream;

        public Builder(OutputStream outputStream) {
            this.outputStream = outputStream;
        }

        public DefaultHappyCaptcha builder() {
            return new DefaultHappyCaptcha(this);
        }
    }

    static class DefaultCaptcha extends Captcha {

        protected String exp;

        private DefaultCaptcha(String exp) {
            this.exp = exp;
        }

        @Override
        protected Color color() {
            return CommonCaptchaUtil.getColor();
        }

        public void drawImage(char[] chars, OutputStream output) {
            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
            Graphics2D g = (Graphics2D) img.getGraphics();
            g.setBackground(Color.WHITE);
            g.fillRect(0, 0, width, height);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            drawLine(g);
            drawOval(g);
            drawBezierLine(g);
            g.setFont(getFont());
            FontMetrics fontMetrics = g.getFontMetrics();
            int fw = (width / chars.length) - 2;
            int fm = (fw - (int) fontMetrics.getStringBounds("8", g).getWidth()) / 2;

            Color fontColor = color();
            for (int i = 0; i < chars.length; i++) {
                g.setColor(fontColor);
                int fh = height - ((height - (int) fontMetrics.getStringBounds(String.valueOf(chars[i]), g).getHeight()) >> 1);
                g.drawString(String.valueOf(chars[i]), i * fw + fm, fh);
            }
            g.dispose();
            try {
                ImageIO.write(img, "png", output);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
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

    static class DefaultAnimCaptcha extends AnimCaptcha {

        protected String exp;

        public DefaultAnimCaptcha(String exp) {
            this.exp = exp;
        }

        @Override
        protected Color color() {
            return CommonCaptchaUtil.getColor();
        }

        public BufferedImage drawImage(Color[] colors, char[] chars, int index, int[][] bezier) {
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
            Graphics2D g = (Graphics2D) image.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);
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
            int fw = (width / chars.length) - 2;
            int fm = (fw - (int) fontMetrics.getStringBounds("W", g).getWidth()) / 2;

            Color fontColor = color();
            for (int i = 0; i < chars.length; i++) {
                AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getAlpha(index, i));
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

}
