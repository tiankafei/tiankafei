package org.tiankafei.ui.control;

import java.awt.Color;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import org.tiankafei.base.datetime.DateTimeUtil;
import org.tiankafei.base.enums.DateTimeEnum;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.design.againsui.TiankafeiLabel;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.modelsui.TkfLabel;

/**
 * @author 甜咖啡
 */
public class TiankafeiTimeControls {

    private static final String[] TIMES = new String[]{"日", "时", "分", "秒"};

    private int index = 3;

    private String formatType = DateTimeEnum.YYYY_NAME_MM_NAME_DDHH_NAME_MM.getCode();

    public TiankafeiTimeControls() {

    }

    public TkfLabel initTiankafeiTimeControls() throws BaseException {
        TiankafeiLabel tiankafeiLabel = new TiankafeiLabel();
        tiankafeiLabel.setTopBorderWidth(1);
        tiankafeiLabel.setBottomBorderWidth(1);
        tiankafeiLabel.setLeftBorderWidth(1);
        tiankafeiLabel.setRightBorderWidth(1);
        tiankafeiLabel.setBorderColor(Color.BLACK);
        tiankafeiLabel.setWidth(260);

        tiankafeiLabel.setTextHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);
        TkfLabel tkfLabel = tiankafeiLabel.initTiankafeiLabel();

        Calendar calendar = Calendar.getInstance();

        /**默认一秒*/
        int intervalTime = 1000;
        switch (index) {
            case 0:
                formatType = DateTimeEnum.YYYY_NAME_MM_NAME_DD.getCode();
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
                intervalTime = 1000 * 60 * 60 * 24;
                break;
            case 1:
                formatType = DateTimeEnum.YYYY_NAME_MM_NAME_DDHH.getCode();
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + 1);
                intervalTime = 1000 * 60 * 60;
                break;
            case 2:
                formatType = DateTimeEnum.YYYY_NAME_MM_NAME_DDHH_NAME_MM.getCode();
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 1);
                intervalTime = 1000 * 60;
                break;
            case 3:
                formatType = DateTimeEnum.YYYY_NAME_MM_NAME_DDHH_NAME_MM_NAME_SS.getCode();
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 1);
                intervalTime = 1000;
                break;
            default:
                formatType = DateTimeEnum.YYYY_NAME_MM_NAME_DDHH_NAME_MM.getCode();
                calendar.set(Calendar.MILLISECOND, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 1);
                intervalTime = 1000 * 60;
                break;
        }
        //设置当前时间
        setCurrentTime(tkfLabel);
        //定时每个一秒种更新一下文本值
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    setCurrentTime(tkfLabel);
                } catch (BaseException e) {
                    e.printStackTrace();
                }
            }
        }, calendar.getTime(), intervalTime);

        return tkfLabel;
    }

    /**
     * 设置当前时间
     *
     * @param tkfLabel 当前时间标签
     * @throws BaseException 自定义异常
     */
    private void setCurrentTime(TkfLabel tkfLabel) throws BaseException {
        Calendar calendar = Calendar.getInstance();
        String week = DateTimeUtil.getWeekChineseName(calendar);
        String dateTime = DateTimeUtil.getCurrentTime(calendar, formatType);
        tkfLabel.setText(week + " " + dateTime);
    }

    public static String[] getTimes() {
        return TIMES;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
