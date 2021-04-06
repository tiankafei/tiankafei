package org.tiankafei.ui.chart.test;

import org.tiankafei.ui.chart.dto.TiankafeiAxisDTO;
import org.tiankafei.ui.chart.dto.TiankafeiAxixPointDTO;
import org.tiankafei.ui.chart.dto.TiankafeiLineCharDTO;
import org.tiankafei.ui.chart.line.TiankafeiLineCharControls;
import org.tiankafei.ui.chart.modelsui.TkfDemoPanel;
import org.tiankafei.ui.design.againsui.TiankafeiFrame;

/**
 * @author 甜咖啡
 */
public class TiankafeiLineCharFrame {

    public static void main(String[] args) {
        TiankafeiFrame tiankafeiFrame = new TiankafeiFrame();
        tiankafeiFrame.setWidth(800);
        tiankafeiFrame.setHeight(600);
        tiankafeiFrame.setTitle("测试自定义窗体");
        tiankafeiFrame.initTiankafeiFrame();

        //线形控件
        TiankafeiLineCharControls tiankafeiLineCharControls = new TiankafeiLineCharControls();
        TiankafeiLineCharDTO tiankafeiLineCharVO = initTiankafeiLineCharVO();
        tiankafeiLineCharControls.setTiankafeiLineCharVO(tiankafeiLineCharVO);
        TkfDemoPanel tkfChartPanel = tiankafeiLineCharControls.initTiankafeiLineCharControls();
        tiankafeiFrame.add(tkfChartPanel);

        tiankafeiFrame.setVisible(true);
    }

    /**
     * 初始化自定义线形参数对象
     *
     * @return 自定义线形参数对象
     */
    private static TiankafeiLineCharDTO initTiankafeiLineCharVO() {
        TiankafeiLineCharDTO tiankafeiLineCharVO = new TiankafeiLineCharDTO();
        tiankafeiLineCharVO.setxLabel("X");
        tiankafeiLineCharVO.setyLabel("Y");

        TiankafeiAxisDTO tiankafeiAxisDto1 = new TiankafeiAxisDTO();
        tiankafeiAxisDto1.setTitle("Series 1");
        tiankafeiLineCharVO.getTiankafeiAxisList().add(tiankafeiAxisDto1);

        TiankafeiAxisDTO tiankafeiAxisDto2 = new TiankafeiAxisDTO();
        tiankafeiAxisDto2.setTitle("Series 2");
        tiankafeiLineCharVO.getTiankafeiAxisList().add(tiankafeiAxisDto2);

        int number = 20;
        for (int pointIndex = 0; pointIndex < number; pointIndex++) {
            TiankafeiAxixPointDTO tiankafeiAxixPointDto1 = new TiankafeiAxixPointDTO();
            tiankafeiAxixPointDto1.setxPointValue(pointIndex);
            tiankafeiAxixPointDto1.setyPointValue(pointIndex);
            tiankafeiAxisDto1.getTiankafeiAxixPointList().add(tiankafeiAxixPointDto1);

            TiankafeiAxixPointDTO tiankafeiAxixPointDto2 = new TiankafeiAxixPointDTO();
            tiankafeiAxixPointDto2.setxPointValue(pointIndex);
            tiankafeiAxixPointDto2.setyPointValue(20 - pointIndex);
            tiankafeiAxisDto2.getTiankafeiAxixPointList().add(tiankafeiAxixPointDto2);
        }
        return tiankafeiLineCharVO;
    }

}
