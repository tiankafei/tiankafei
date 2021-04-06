package org.tiankafei.ui.design.util;

import javax.swing.ImageIcon;
import org.tiankafei.common.enums.BaseEnum;
import org.tiankafei.common.util.FileUtil;


/**
 * Image图标工具类
 *
 * @author tiankafei
 */
public class ImageIconUtil {

    private ImageIconUtil() {

    }

    /**
     * 获取图标路径的Image对象
     *
     * @param imageIconPath 图标路径
     * @return 图标路径的Image对象
     */
    public static ImageIcon getScaledImageIcon(String imageIconPath) {
        return getScaledImageIcon(imageIconPath, 20, 20);
    }

    /**
     * 获取图标路径的Image对象
     *
     * @param imageIconPath 图标路径
     * @param width         图标宽度
     * @param height        图标高度
     * @return 图标路径的Image对象
     */
    public static ImageIcon getScaledImageIcon(String imageIconPath, int width, int height) {
        return getScaledImageIcon(imageIconPath, width, height, java.awt.Image.SCALE_SMOOTH);
    }

    /**
     * 获取图标路径的Image对象
     *
     * @param imageIconPath 图标路径
     * @param width         图标宽度
     * @param height        图标高度
     * @param scaledType    图标规模类型
     * @return 图标路径的Image对象
     */
    public static ImageIcon getScaledImageIcon(String imageIconPath, int width, int height, int scaledType) {
        ImageIcon imageIcon = new ImageIcon(FileUtil.readImage(imageIconPath));
        if (!imageIconPath.toLowerCase().endsWith(BaseEnum.FILE_SUFFIX_GIF.getValue())) {
            //gif图片不做缩放
            setImage(imageIcon, width, height, scaledType);
        }
        return imageIcon;
    }

    /**
     * 设置ImageIcon图标缩放
     *
     * @param imageIcon 要缩放的图标对象
     */
    public static void setImage(ImageIcon imageIcon) {
        setImage(imageIcon, 20, 20);
    }

    /**
     * 设置ImageIcon图标缩放
     *
     * @param imageIcon 要缩放的图标对象
     * @param width     要缩放的宽度
     * @param height    要缩放的高度
     */
    public static void setImage(ImageIcon imageIcon, int width, int height) {
        setImage(imageIcon, width, height, java.awt.Image.SCALE_SMOOTH);
    }

    /**
     * 设置ImageIcon图标缩放
     *
     * @param imageIcon  要缩放的图标对象
     * @param width      要缩放的宽度
     * @param height     要缩放的高度
     * @param scaledType 缩放类型
     */
    public static void setImage(ImageIcon imageIcon, int width, int height, int scaledType) {
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, scaledType));
    }

}
