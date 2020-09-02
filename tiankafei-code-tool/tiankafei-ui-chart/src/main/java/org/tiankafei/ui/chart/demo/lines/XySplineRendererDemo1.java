package org.tiankafei.ui.chart.demo.lines;

import javax.swing.JPanel;
import org.tiankafei.ui.design.modelsui.TkfFrame;
import org.tiankafei.ui.design.util.TiankafeiComponentUtil;

/**
 * @author 甜咖啡
 */
public class XySplineRendererDemo1 extends TkfFrame {

    private static final long serialVersionUID = 3936726066813469014L;

    public XySplineRendererDemo1(String paramString) {
        super(paramString);
        JPanel localPanel = createDemoPanel();
        getContentPane().add(localPanel);
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] paramArrayOfString) {
        XySplineRendererDemo1 localXySplineRendererDemo1 = new XySplineRendererDemo1("曲线图");
        localXySplineRendererDemo1.pack();
        TiankafeiComponentUtil.setCenter(localXySplineRendererDemo1);
        localXySplineRendererDemo1.setVisible(true);
    }
}