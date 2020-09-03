package org.tiankafei.ui.control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.tiankafei.base.datetime.DateTimeUtil;
import org.tiankafei.base.enums.DateTimeEnum;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.ui.control.datetime.DataTimeControlsDTO;
import org.tiankafei.base.util.DataOperateUtil;
import org.tiankafei.ui.design.againsui.TiankafeiButton;
import org.tiankafei.ui.design.againsui.TiankafeiComboBox;
import org.tiankafei.ui.design.againsui.TiankafeiDialog;
import org.tiankafei.ui.design.againsui.TiankafeiLabel;
import org.tiankafei.ui.design.againsui.TiankafeiPanel;
import org.tiankafei.ui.design.constant.TiankafeiDesignerConstants;
import org.tiankafei.ui.design.modelsui.TkfButton;
import org.tiankafei.ui.design.modelsui.TkfComboBox;
import org.tiankafei.ui.design.modelsui.TkfLabel;
import org.tiankafei.ui.design.modelsui.TkfPanel;

/**
 * 自定义日期事件选择控件
 *
 * @author 甜咖啡
 */
public class TiankafeiDateTimeControls {

    /**
     * 自定义对话框对象
     */
    private TiankafeiDialog tiankafeiDialog;

    /**
     * 时间日期选择内容面板
     */
    private TkfPanel dateTimeChooseContentTkfPanel;

    /**
     * 当前日期
     */
    private Calendar currentCalendar;

    /**
     * 选择的日期
     */
    private Calendar selectCalendar;

    /**
     * 格式化时间
     */
    private String formatSimpleDateFormat;

    /**
     * 格式化时间
     */
    private String formatSimpleDateFormat1;

    /**
     * 行间距
     */
    private int widthDistance;

    /**
     * 标题背景色
     */
    private Color titleBackgroundColor;

    /**
     * 日期选择背景色
     */
    private Color dateBackgroundColor;

    /**
     * 控件宽度
     */
    private int controlsWidth;

    /**
     * 控件高度
     */
    private int controlsHeight;

    /**
     * 标题高度
     */
    private int titleHeight;

    /**
     * 控件标题
     */
    private String controlsTitle;

    /**
     * 日期内容标签
     */
    private TkfLabel[] tkfLabelArray;

    /**
     * 返回标识
     */
    private boolean returnFlag;

    /**
     * 日期选择标识(1:年月日;2:年月日时;3:年月日时分;4:年月日时分秒)
     */
    private int dateTimeChooseType;

    /**
     * 为true日期选中，为false确定选中
     */
    private boolean chooseDateFlag;

    /**
     * 时间下拉框
     */
    private TkfComboBox<?>[] tkfComboBoxArray;

    /**
     * 当前时间控件对象
     */
    private DataTimeControlsDTO currentDataTimeControlsDTO;

    /**
     * 构造自定义日期事件选择控件
     *
     * @throws BaseException 自定义异常
     */
    public TiankafeiDateTimeControls() {
        formatSimpleDateFormat1 = DateTimeEnum.YYYY_NAME_MM_NAME_DD.getCode();
        currentCalendar = Calendar.getInstance();
        selectCalendar = Calendar.getInstance();
        widthDistance = 16;
        titleBackgroundColor = new Color(160, 185, 215);
        dateBackgroundColor = Color.WHITE;
        controlsWidth = 400;
        controlsHeight = 300;
        titleHeight = 30;
        controlsTitle = "日期选择器";
        returnFlag = false;
        dateTimeChooseType = 1;
        chooseDateFlag = true;
    }

    /**
     * 初始化自定义日期事件选择控件
     *
     * @return 自定义日期事件选择控件
     * @throws BaseException 自定义异常
     */
    public TiankafeiDialog initTiankafeiDateTimeControls() throws BaseException {
        String format = getDefaultFormatType();
        return initTiankafeiDateTimeControls(new Date(), format);
    }

    /**
     * 初始化自定义日期事件选择控件
     *
     * @param dateTime 时间
     * @return 自定义日期事件选择控件
     * @throws BaseException 自定义异常
     */
    public TiankafeiDialog initTiankafeiDateTimeControls(String dateTime) throws BaseException {
        String format = getDefaultFormatType();
        return initTiankafeiDateTimeControls(DateTimeUtil.stringToDate(dateTime, format), format);
    }

    /**
     * 初始化自定义日期事件选择控件
     *
     * @param dateTime 时间
     * @param format   时间格式
     * @return 自定义日期事件选择控件
     * @throws BaseException 自定义异常
     */
    public TiankafeiDialog initTiankafeiDateTimeControls(String dateTime, String format) throws BaseException {
        return initTiankafeiDateTimeControls(DateTimeUtil.stringToDate(dateTime, format), format);
    }

    /**
     * 初始化自定义日期事件选择控件
     *
     * @param date   时间
     * @param format 时间格式
     * @return 自定义日期事件选择控件
     * @throws BaseException 自定义异常
     */
    public TiankafeiDialog initTiankafeiDateTimeControls(Date date, String format) throws BaseException {
        currentCalendar = Calendar.getInstance();
        formatSimpleDateFormat = format;
        selectCalendar.setTime(date);

        int length = 2;
        int number2 = 2;
        int number3 = 3;
        int number4 = 4;
        if (number2 == getDateTimeChooseType()) {
            length = 3;
        } else if (number3 == getDateTimeChooseType()) {
            length = 4;
        } else if (number4 == getDateTimeChooseType()) {
            length = 5;
        }
        tkfComboBoxArray = new TkfComboBox<?>[length];

        tiankafeiDialog = new TiankafeiDialog();
        tiankafeiDialog.setWidth(controlsWidth);
        tiankafeiDialog.setHeight(controlsHeight);
        tiankafeiDialog.setTitle(controlsTitle);
        tiankafeiDialog.getTiankafeiFrameAttributeVO().setFrameExitFlag(false);
        tiankafeiDialog.initTiankafeiDialog();
        tiankafeiDialog.setModal(true);

        TiankafeiPanel tiankafeiPanel = new TiankafeiPanel();
        TkfPanel dataTimeTkfPanel = tiankafeiPanel.initTiankafeiPanel();
        tiankafeiDialog.add(dataTimeTkfPanel);
        //初始化选择年份和月份面板
        TkfPanel chooseYearAndMonthPanel = initChooseYearAndMonthPanel();
        dataTimeTkfPanel.add(chooseYearAndMonthPanel, BorderLayout.NORTH);
        //初始化时间日期选择面板
        TkfPanel dateTimeChooseTkfPanel = initDateTimeChoosePanel();
        dataTimeTkfPanel.add(dateTimeChooseTkfPanel, BorderLayout.CENTER);
        //初始化当前时间面板
        TkfPanel currentDateTimeTkfPanel = initCurrentDateTimePanel();
        dataTimeTkfPanel.add(currentDateTimeTkfPanel, BorderLayout.SOUTH);
        //初始化自定义日期事件选择控件的数据
        initTiankafeiDateTimeControlsData();

        return tiankafeiDialog;
    }

    /**
     * 获取时间格式
     *
     * @return 时间格式
     */
    private String getDefaultFormatType() {
        int number2 = 2;
        int number3 = 3;
        int number4 = 4;
        String format = DateTimeEnum.YYYY_MM_DD.getCode();
        if (getDateTimeChooseType() == number2) {
            format = DateTimeEnum.YYYY_MM_DDHH.getCode();
        } else if (getDateTimeChooseType() == number3) {
            format = DateTimeEnum.YYYY_MM_DDHH_MM.getCode();
        } else if (getDateTimeChooseType() == number4) {
            format = DateTimeEnum.YYYY_MM_DDHH_MM_SS.getCode();
        }
        return format;
    }

    /**
     * 初始化自定义日期事件选择控件的数据
     *
     * @throws BaseException
     */
    private void initTiankafeiDateTimeControlsData() throws BaseException {
        //更新时间
        updateDateTime();
        //更新时间选择的内容
        updateDateTimeContent();
    }

    /**
     * 初始化选择年份和月份面板
     *
     * @throws BaseException
     */
    private TkfPanel initChooseYearAndMonthPanel() throws BaseException {
        TiankafeiPanel chooseYearAndMonthTiankafeiPanel = new TiankafeiPanel();
        chooseYearAndMonthTiankafeiPanel.setBackgroundColor(titleBackgroundColor);
        chooseYearAndMonthTiankafeiPanel.setWidth(controlsWidth);
        chooseYearAndMonthTiankafeiPanel.setHeight(titleHeight);
        TkfPanel chooseYearAndMonthPanel = chooseYearAndMonthTiankafeiPanel.initTiankafeiPanel();
        //上一年
        TiankafeiLabel previousYearLabel = new TiankafeiLabel();
        previousYearLabel.setText("  <<");
        previousYearLabel.setToolTipText("上一年");
        final TkfLabel previousYearTkfLabel = previousYearLabel.initTiankafeiLabel();
        addMouseAdapter(previousYearTkfLabel, Calendar.YEAR, -1);
        chooseYearAndMonthPanel.add(previousYearTkfLabel, BorderLayout.WEST);
        //选择月份面板
        TiankafeiPanel monthTiankafeiPanel = new TiankafeiPanel();
        TkfPanel monthPanel = monthTiankafeiPanel.initTiankafeiPanel();
        monthPanel.setOpaque(false);
        chooseYearAndMonthPanel.add(monthPanel, BorderLayout.CENTER);
        //上一月
        TiankafeiLabel previousMonthLabel = new TiankafeiLabel();
        previousMonthLabel.setText("  <");
        previousMonthLabel.setToolTipText("上月");
        final TkfLabel previousMonthkfLabel = previousMonthLabel.initTiankafeiLabel();
        previousMonthkfLabel.setBorder(BorderFactory.createEmptyBorder(0, widthDistance, 0, 0));
        addMouseAdapter(previousMonthkfLabel, Calendar.MONTH, -1);
        monthPanel.add(previousMonthkfLabel, BorderLayout.WEST);
        //时间标签面板
        TiankafeiPanel dateTimeTiankafeiPanel = new TiankafeiPanel();
        TkfPanel dateTimeTkfPanel = dateTimeTiankafeiPanel.initTiankafeiPanel();
        dateTimeTkfPanel.setOpaque(false);
        dateTimeTkfPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        monthPanel.add(dateTimeTkfPanel, BorderLayout.CENTER);
        //年
        String[] years = DateTimeUtil.getYearArray();
        setTkfComboBoxArray(0, dateTimeTkfPanel, "年", years);
        tkfComboBoxArray[0].addItemListener(new SelectYearItemListener());
        //月
        String[] months = DataOperateUtil.getFromOneArray(12);
        setTkfComboBoxArray(1, dateTimeTkfPanel, "月", months);
        tkfComboBoxArray[1].addItemListener(new SelectMonthItemListener());
        //下一月
        TiankafeiLabel nextMonthLabel = new TiankafeiLabel();
        nextMonthLabel.setText(">  ");
        nextMonthLabel.setToolTipText("下一月");
        final TkfLabel nextMonthTkfLabel = nextMonthLabel.initTiankafeiLabel();
        nextMonthTkfLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, widthDistance));
        addMouseAdapter(nextMonthTkfLabel, Calendar.MONTH, 1);
        monthPanel.add(nextMonthTkfLabel, BorderLayout.EAST);
        //下一年
        TiankafeiLabel nextYearLabel = new TiankafeiLabel();
        nextYearLabel.setText(">>  ");
        nextYearLabel.setToolTipText("下一年");
        final TkfLabel nextYearTkfLabel = nextYearLabel.initTiankafeiLabel();
        addMouseAdapter(nextYearTkfLabel, Calendar.YEAR, 1);
        chooseYearAndMonthPanel.add(nextYearTkfLabel, BorderLayout.EAST);
        return chooseYearAndMonthPanel;
    }

    class SelectYearItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                try {
                    setSelectCalendar();
                    updateDateTimeContent();
                } catch (BaseException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    class SelectMonthItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                try {
                    setSelectCalendar();
                    updateDateTimeContent();
                } catch (BaseException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 初始化时间日期选择面板
     *
     * @return 时间日期选择面板
     * @throws BaseException
     */
    private TkfPanel initDateTimeChoosePanel() throws BaseException {
        TiankafeiPanel dateTimeChooseTiankafeiPanel = new TiankafeiPanel();
        dateTimeChooseTiankafeiPanel.setBackgroundColor(dateBackgroundColor);
        dateTimeChooseTiankafeiPanel.setWidth(controlsWidth);
        dateTimeChooseTiankafeiPanel.setHeight(controlsHeight - titleHeight);
        TkfPanel dateTimeChooseTkfPanel = dateTimeChooseTiankafeiPanel.initTiankafeiPanel();
        //初始化时间日期选择标题面板
        TkfPanel dateTimeChooseTitleTkfPanel = initDateTimeChooseTitlePanel();
        dateTimeChooseTkfPanel.add(dateTimeChooseTitleTkfPanel, BorderLayout.NORTH);
        //初始化时间日期选择内容面板
        dateTimeChooseContentTkfPanel = initDateTimeChooseContentPanel();
        dateTimeChooseTkfPanel.add(dateTimeChooseContentTkfPanel, BorderLayout.CENTER);

        TiankafeiPanel timeChooseContentTiankafeiPanel = new TiankafeiPanel();
        TkfPanel timeChooseContentTkfPanel = timeChooseContentTiankafeiPanel.initTiankafeiPanel();
        timeChooseContentTkfPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        dateTimeChooseTkfPanel.add(timeChooseContentTkfPanel, BorderLayout.SOUTH);

        int number2 = 2;
        int number3 = 3;
        int number4 = 4;
        if (getDateTimeChooseType() >= number2) {
            String[] hours = DataOperateUtil.getFromZeroArray(24);
            setTkfComboBoxArray(2, timeChooseContentTkfPanel, "时", hours);
        }
        if (getDateTimeChooseType() >= number3) {
            String[] minute = DataOperateUtil.getFromZeroArray(60);
            setTkfComboBoxArray(3, timeChooseContentTkfPanel, "分", minute);
        }
        if (getDateTimeChooseType() >= number4) {
            String[] second = DataOperateUtil.getFromZeroArray(60);
            setTkfComboBoxArray(4, timeChooseContentTkfPanel, "秒", second);
        }

        if (getDateTimeChooseType() >= number2 && !isChooseDateFlag()) {
            TiankafeiButton confireTiankafeiButton = new TiankafeiButton();
            confireTiankafeiButton.setText("确定");
            TkfButton confireTkfButton = confireTiankafeiButton.initTiankafeiButton();
            timeChooseContentTkfPanel.add(confireTkfButton);
            confireTkfButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int year = Integer.parseInt(tkfComboBoxArray[0].getSelectedItem().toString());
                    int month = currentDataTimeControlsDTO.getMonth();
                    int days = selectCalendar.get(Calendar.DAY_OF_MONTH);
                    setSelectCalendar(year, month, days);

                    returnFlag = true;
                    tiankafeiDialog.setVisible(false);
                }
            });
        }
        return dateTimeChooseTkfPanel;
    }

    /**
     * 初始化时间日期选择标题面板
     *
     * @return 时间日期选择标题面板
     * @throws BaseException
     */
    private TkfPanel initDateTimeChooseTitlePanel() throws BaseException {
        TiankafeiPanel dateTimeChooseTitleTiankafeiPanel = new TiankafeiPanel();
        dateTimeChooseTitleTiankafeiPanel.setBackgroundColor(dateBackgroundColor);
        dateTimeChooseTitleTiankafeiPanel.setWidth(controlsWidth);
        dateTimeChooseTitleTiankafeiPanel.setHeight(titleHeight);
        TkfPanel dateTimeChooseTitleTkfPanel = dateTimeChooseTitleTiankafeiPanel.initTiankafeiPanel();
        dateTimeChooseTitleTkfPanel.setLayout(new GridLayout(1, 7));

        TiankafeiLabel tiankafeiLabel1 = new TiankafeiLabel();
        tiankafeiLabel1.setText("星期日");
        tiankafeiLabel1.setTextHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);
        dateTimeChooseTitleTkfPanel.add(tiankafeiLabel1.initTiankafeiLabel());

        TiankafeiLabel tiankafeiLabel2 = new TiankafeiLabel();
        tiankafeiLabel2.setText("星期一");
        tiankafeiLabel2.setTextHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);
        dateTimeChooseTitleTkfPanel.add(tiankafeiLabel2.initTiankafeiLabel());

        TiankafeiLabel tiankafeiLabel3 = new TiankafeiLabel();
        tiankafeiLabel3.setText("星期二");
        tiankafeiLabel3.setTextHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);
        dateTimeChooseTitleTkfPanel.add(tiankafeiLabel3.initTiankafeiLabel());

        TiankafeiLabel tiankafeiLabel4 = new TiankafeiLabel();
        tiankafeiLabel4.setText("星期三");
        tiankafeiLabel4.setTextHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);
        dateTimeChooseTitleTkfPanel.add(tiankafeiLabel4.initTiankafeiLabel());

        TiankafeiLabel tiankafeiLabel5 = new TiankafeiLabel();
        tiankafeiLabel5.setText("星期四");
        tiankafeiLabel5.setTextHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);
        dateTimeChooseTitleTkfPanel.add(tiankafeiLabel5.initTiankafeiLabel());

        TiankafeiLabel tiankafeiLabel6 = new TiankafeiLabel();
        tiankafeiLabel6.setText("星期五");
        tiankafeiLabel6.setTextHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);
        dateTimeChooseTitleTkfPanel.add(tiankafeiLabel6.initTiankafeiLabel());

        TiankafeiLabel tiankafeiLabel7 = new TiankafeiLabel();
        tiankafeiLabel7.setText("星期六");
        tiankafeiLabel7.setTextHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);
        dateTimeChooseTitleTkfPanel.add(tiankafeiLabel7.initTiankafeiLabel());

        return dateTimeChooseTitleTkfPanel;
    }

    /**
     * 初始化时间日期选择内容面板
     *
     * @return 时间日期选择内容面板
     */
    private TkfPanel initDateTimeChooseContentPanel() {
        TiankafeiPanel dateTimeChooseContentTiankafeiPanel = new TiankafeiPanel();
        dateTimeChooseContentTiankafeiPanel.setBackgroundColor(dateBackgroundColor);
        dateTimeChooseContentTiankafeiPanel.setWidth(controlsWidth);
        dateTimeChooseContentTiankafeiPanel.setHeight(controlsHeight - titleHeight * 3);
        TkfPanel dateTimeChooseContentTkfPanel = dateTimeChooseContentTiankafeiPanel.initTiankafeiPanel();
        dateTimeChooseContentTkfPanel.setLayout(new GridLayout(6, 7));

        return dateTimeChooseContentTkfPanel;
    }

    /**
     * 初始化当前时间面板
     *
     * @throws BaseException
     */
    private TkfPanel initCurrentDateTimePanel() throws BaseException {
        TiankafeiPanel currentDateTimeTiankafeiPanel = new TiankafeiPanel();
        currentDateTimeTiankafeiPanel.setBackgroundColor(titleBackgroundColor);
        currentDateTimeTiankafeiPanel.setWidth(controlsWidth);
        currentDateTimeTiankafeiPanel.setHeight(titleHeight);
        TkfPanel currentDateTimeTkfPanel = currentDateTimeTiankafeiPanel.initTiankafeiPanel();
        currentDateTimeTkfPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        TiankafeiLabel currentDateTimeTiankafeiLabel = new TiankafeiLabel();
        int year = currentCalendar.get(Calendar.YEAR);
        int month = currentCalendar.get(Calendar.MONTH);
        int days = currentCalendar.get(Calendar.DAY_OF_MONTH);
        DataTimeControlsDTO dataTimeControlsDTO = new DataTimeControlsDTO(year, month, days);
        currentDateTimeTiankafeiLabel.getTiankafeiModelUiVO().setParamObject(dataTimeControlsDTO);
        currentDateTimeTiankafeiLabel.setToolTipText("点击选择今天日期");
        currentDateTimeTiankafeiLabel.setText("今天: " + DateFormatUtils.format(currentCalendar.getTime(), formatSimpleDateFormat));
        final TkfLabel currentDateTimeTkfLabel = currentDateTimeTiankafeiLabel.initTiankafeiLabel();
        currentDateTimeTkfPanel.add(currentDateTimeTkfLabel);
        currentDateTimeTkfLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                currentDateTimeTkfLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                currentDateTimeTkfLabel.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                currentDateTimeTkfLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                currentDateTimeTkfLabel.setForeground(Color.BLACK);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                selectCalendar.setTime(currentCalendar.getTime());
                returnFlag = true;
                tiankafeiDialog.setVisible(false);
            }
        });
        return currentDateTimeTkfPanel;
    }

    /**
     * 更新时间
     */
    private void updateDateTime() {
        int month = selectCalendar.get(Calendar.MONTH);
        int hour = selectCalendar.get(Calendar.HOUR_OF_DAY);
        int minute = selectCalendar.get(Calendar.MINUTE);
        int second = selectCalendar.get(Calendar.SECOND);
        tkfComboBoxArray[0].setSelectedItem(String.valueOf(selectCalendar.get(Calendar.YEAR)));
        tkfComboBoxArray[1].setSelectedIndex(month);

        int number2 = 2;
        int number3 = 3;
        int number4 = 4;
        if (getDateTimeChooseType() >= number2) {
            tkfComboBoxArray[2].setSelectedIndex(hour);
        }
        if (getDateTimeChooseType() >= number3) {
            tkfComboBoxArray[3].setSelectedIndex(minute);
        }
        if (getDateTimeChooseType() >= number4) {
            tkfComboBoxArray[4].setSelectedIndex(second);
        }
    }

    /**
     * 更新时间选择的内容
     *
     * @throws BaseException
     */
    private void updateDateTimeContent() throws BaseException {
        dateTimeChooseContentTkfPanel.removeAll();
        //选择日期
        Date selectDate = selectCalendar.getTime();
        //当前日期选择器
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.setTime(selectDate);
        newCalendar.set(Calendar.DAY_OF_MONTH, 1);
        //选择的月份
        int chooseMonth = newCalendar.get(Calendar.MONTH);
        //一周中的第几天
        int index = newCalendar.get(Calendar.DAY_OF_WEEK);
        int sum = (index == 1 ? 8 : index);
        newCalendar.add(Calendar.DAY_OF_MONTH, 0 - sum);

        tkfLabelArray = new TkfLabel[42];
        //增加日期选择
        for (int i = 0, lem = tkfLabelArray.length; i < lem; i++) {
            newCalendar.add(Calendar.DAY_OF_MONTH, 1);
            //日期标签
            tkfLabelArray[i] = getTkfLabel(newCalendar, chooseMonth);
            dateTimeChooseContentTkfPanel.add(tkfLabelArray[i]);
        }
        //增加点击事件
        for (int i = 0, lem = tkfLabelArray.length; i < lem; i++) {
            final TkfLabel tkfLabel = tkfLabelArray[i];
            tkfLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (int i = 0, lem = tkfLabelArray.length; i < lem; i++) {
                        tkfLabelArray[i].setBackground(Color.WHITE);
                        if ("2".equals(tkfLabelArray[i].getTiankafeiModelUiVO().getParamCode())) {
                            tkfLabelArray[i].setForeground(Color.LIGHT_GRAY);
                        }
                    }
                    tkfLabel.setBackground(titleBackgroundColor);
                    if ("2".equals(tkfLabel.getTiankafeiModelUiVO().getParamCode())) {
                        tkfLabel.setForeground(Color.BLACK);
                    }
                    //确认选择
                    currentDataTimeControlsDTO = (DataTimeControlsDTO) tkfLabel.getTiankafeiModelUiVO().getParamObject();
                    setSelectCalendar(currentDataTimeControlsDTO);
                    if (getDateTimeChooseType() >= 2 && !isChooseDateFlag()) {
                    } else {
                        returnFlag = true;
                        tiankafeiDialog.setVisible(false);
                    }
                }
            });
        }
        dateTimeChooseContentTkfPanel.updateUI();
    }

    /**
     * 设置选择日期控件时间
     *
     * @param dataTimeControlsDTO 时间控件对象
     */
    private void setSelectCalendar(DataTimeControlsDTO dataTimeControlsDTO) {
        int year = dataTimeControlsDTO.getYear();
        int month = dataTimeControlsDTO.getMonth();
        int days = dataTimeControlsDTO.getDays();
        setSelectCalendar(year, month, days);
    }

    /**
     * 获取日期内容标签
     *
     * @param newCalendar 新建的日期选择器
     * @param chooseMonth 选择的当前月份
     * @return 日期内容标签
     * @throws BaseException
     */
    private TkfLabel getTkfLabel(Calendar newCalendar, int chooseMonth) throws BaseException {
        int year = newCalendar.get(Calendar.YEAR);
        int month = newCalendar.get(Calendar.MONTH);
        int days = newCalendar.get(Calendar.DAY_OF_MONTH);
        int currentYear = currentCalendar.get(Calendar.YEAR);
        int currentMonth = currentCalendar.get(Calendar.MONTH);
        int currentDays = currentCalendar.get(Calendar.DAY_OF_MONTH);
        int selectYear = selectCalendar.get(Calendar.YEAR);
        int selectMonth = selectCalendar.get(Calendar.MONTH);
        int selectDays = selectCalendar.get(Calendar.DAY_OF_MONTH);

        final TiankafeiLabel tiankafeiLabel = new TiankafeiLabel();
        if (currentYear == year && currentMonth == month && currentDays == days) {
            tiankafeiLabel.setTopBorderWidth(1);
            tiankafeiLabel.setBottomBorderWidth(1);
            tiankafeiLabel.setLeftBorderWidth(1);
            tiankafeiLabel.setRightBorderWidth(1);
            tiankafeiLabel.setBorderColor(Color.RED);
            tiankafeiLabel.getTiankafeiModelUiVO().setParamCode("1");
        }
        if (selectYear == year && selectMonth == month && selectDays == days) {
            tiankafeiLabel.setBackgroundColor(titleBackgroundColor);
        }
        if (chooseMonth != month) {
            tiankafeiLabel.setForegroundColor(Color.LIGHT_GRAY);
            tiankafeiLabel.getTiankafeiModelUiVO().setParamCode("2");
        }
        DataTimeControlsDTO dataTimeControlsDTO = new DataTimeControlsDTO(year, month, days);
        tiankafeiLabel.getTiankafeiModelUiVO().setParamObject(dataTimeControlsDTO);
        tiankafeiLabel.setText(String.valueOf(days));
        tiankafeiLabel.setToolTipText(DateFormatUtils.format(newCalendar.getTime(), formatSimpleDateFormat1));
        tiankafeiLabel.setTextHorizontalAlignment(TiankafeiDesignerConstants.SWING_CENTER);
        final TkfLabel tkfLabel = tiankafeiLabel.initTiankafeiLabel();
        tkfLabel.setOpaque(true);

        tkfLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                String str = "1";
                if (!str.equals(tiankafeiLabel.getTiankafeiModelUiVO().getParamCode())) {
                    tiankafeiLabel.setTopBorderWidth(1);
                    tiankafeiLabel.setBottomBorderWidth(1);
                    tiankafeiLabel.setLeftBorderWidth(1);
                    tiankafeiLabel.setRightBorderWidth(1);
                    tiankafeiLabel.setBorderColor(Color.BLACK);
                    tiankafeiLabel.setBorder(tkfLabel);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                String str = "1";
                if (!str.equals(tiankafeiLabel.getTiankafeiModelUiVO().getParamCode())) {
                    tiankafeiLabel.setTopBorderWidth(0);
                    tiankafeiLabel.setBottomBorderWidth(0);
                    tiankafeiLabel.setLeftBorderWidth(0);
                    tiankafeiLabel.setRightBorderWidth(0);
                    tiankafeiLabel.setBorder(tkfLabel);
                }
            }
        });

        return tkfLabel;
    }

    /**
     * 设置下拉框
     *
     * @param index     索引位置
     * @param tkfPanel  下拉框放置的面板
     * @param labelText 显示文本
     * @param array     下拉框内容
     * @throws BaseException
     */
    private void setTkfComboBoxArray(int index, TkfPanel tkfPanel, String labelText, String[] array) throws BaseException {
        TiankafeiComboBox<String> yearTiankafeiComboBox = new TiankafeiComboBox<String>(array);
        tkfComboBoxArray[index] = yearTiankafeiComboBox.initTiankafeiComboBox();
        tkfPanel.add(tkfComboBoxArray[index]);
        TiankafeiLabel yearTiankafeiLabel = new TiankafeiLabel();
        yearTiankafeiLabel.setText(labelText);
        TkfLabel yearTkfLabel = yearTiankafeiLabel.initTiankafeiLabel();
        tkfPanel.add(yearTkfLabel);
    }

    /**
     * 获取选取的时间
     *
     * @return 时间
     */
    public String getChooseDateTime() {
        return DateFormatUtils.format(selectCalendar.getTime(), formatSimpleDateFormat);
    }

    /**
     * 增加事件
     *
     * @param tkfLabel 标签
     * @param field    the calendar field.
     * @param amount   the amount of date or time to be added to the field.
     */
    private void addMouseAdapter(final TkfLabel tkfLabel, final int field, final int amount) {
        tkfLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                tkfLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                tkfLabel.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                tkfLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                tkfLabel.setForeground(Color.BLACK);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (field != 0 && amount != 0) {
                    try {
                        selectCalendar.add(field, amount);
                        updateDateTime();
                        updateDateTimeContent();
                    } catch (BaseException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * 设置选择日期控件时间
     */
    private void setSelectCalendar() {
        int year = Integer.parseInt(tkfComboBoxArray[0].getSelectedItem().toString());
        int month = tkfComboBoxArray[1].getSelectedIndex();
        int days = selectCalendar.get(Calendar.DAY_OF_MONTH);
        setSelectCalendar(year, month, days);
    }

    /**
     * 设置选择日期控件时间
     *
     * @param year  年
     * @param month 月
     * @param days  日
     */
    private void setSelectCalendar(int year, int month, int days) {
        int number2 = 2;
        int number3 = 3;
        int number4 = 4;
        if (1 == getDateTimeChooseType()) {
            selectCalendar.set(year, month, days);
        } else if (number2 == getDateTimeChooseType()) {
            selectCalendar.set(year, month, days, tkfComboBoxArray[2].getSelectedIndex(), 0);
        } else if (number3 == getDateTimeChooseType()) {
            selectCalendar.set(year, month, days, tkfComboBoxArray[2].getSelectedIndex(), tkfComboBoxArray[3].getSelectedIndex());
        } else if (number4 == getDateTimeChooseType()) {
            selectCalendar.set(year, month, days, tkfComboBoxArray[2].getSelectedIndex(), tkfComboBoxArray[3].getSelectedIndex(), tkfComboBoxArray[4].getSelectedIndex());
        }
    }

    /**
     * 获取当前日期
     *
     * @return 当前日期
     */
    public Calendar getCurrentCalendar() {
        return currentCalendar;
    }

    /**
     * 设置当前日期
     *
     * @param currentCalendar 当前日期
     */
    public void setCurrentCalendar(Calendar currentCalendar) {
        this.currentCalendar = currentCalendar;
    }

    /**
     * 获取行间距
     *
     * @return 行间距
     */
    public int getWidthDistance() {
        return widthDistance;
    }

    /**
     * 设置行间距
     *
     * @param widthDistance 行间距
     */
    public void setWidthDistance(int widthDistance) {
        this.widthDistance = widthDistance;
    }

    /**
     * 获取标题背景色
     *
     * @return 标题背景色
     */
    public Color getTitleBackgroundColor() {
        return titleBackgroundColor;
    }

    /**
     * 设置标题背景色
     *
     * @param titleBackgroundColor 标题背景色
     */
    public void setTitleBackgroundColor(Color titleBackgroundColor) {
        this.titleBackgroundColor = titleBackgroundColor;
    }

    /**
     * 获取日期选择背景色
     *
     * @return 日期选择背景色
     */
    public Color getDateBackgroundColor() {
        return dateBackgroundColor;
    }

    /**
     * 设置日期选择背景色
     *
     * @param dateBackgroundColor 日期选择背景色
     */
    public void setDateBackgroundColor(Color dateBackgroundColor) {
        this.dateBackgroundColor = dateBackgroundColor;
    }

    /**
     * 获取控件宽度
     *
     * @return 控件宽度
     */
    public int getControlsWidth() {
        return controlsWidth;
    }

    /**
     * 设置控件宽度
     *
     * @param controlsWidth 控件宽度
     */
    public void setControlsWidth(int controlsWidth) {
        this.controlsWidth = controlsWidth;
    }

    /**
     * 获取控件高度
     *
     * @return 控件高度
     */
    public int getControlsHeight() {
        return controlsHeight;
    }

    /**
     * 设置控件高度
     *
     * @param controlsHeight 控件高度
     */
    public void setControlsHeight(int controlsHeight) {
        this.controlsHeight = controlsHeight;
    }

    /**
     * 获取标题高度
     *
     * @return 标题高度
     */
    public int getTitleHeight() {
        return titleHeight;
    }

    /**
     * 设置标题高度
     *
     * @param titleHeight 标题高度
     */
    public void setTitleHeight(int titleHeight) {
        this.titleHeight = titleHeight;
    }

    /**
     * 获取控件标题
     *
     * @return 控件标题
     */
    public String getControlsTitle() {
        return controlsTitle;
    }

    /**
     * 设置控件标题
     *
     * @param controlsTitle 控件标题
     */
    public void setControlsTitle(String controlsTitle) {
        this.controlsTitle = controlsTitle;
    }

    /**
     * 获取返回标识
     *
     * @return 返回标识
     */
    public boolean isReturnFlag() {
        return returnFlag;
    }

    /**
     * 设置返回标识
     *
     * @param returnFlag 返回标识
     */
    public void setReturnFlag(boolean returnFlag) {
        this.returnFlag = returnFlag;
    }

    /**
     * 获取日期选择标识(1:年月日;2:年月日时;3:年月日时分;4:年月日时分秒)
     *
     * @return 日期选择标识(1 : 年月日 ; 2 : 年月日时 ; 3 : 年月日时分 ; 4 : 年月日时分秒)
     */
    public int getDateTimeChooseType() {
        return dateTimeChooseType;
    }

    /**
     * 设置日期选择标识(1:年月日;2:年月日时;3:年月日时分;4:年月日时分秒)
     *
     * @param dateTimeChooseType 日期选择标识(1:年月日;2:年月日时;3:年月日时分;4:年月日时分秒)
     */
    public void setDateTimeChooseType(int dateTimeChooseType) {
        this.dateTimeChooseType = dateTimeChooseType;
    }

    /**
     * 获取选择标识(为true日期选中，为false确定选中)
     *
     * @return 选择标识
     */
    public boolean isChooseDateFlag() {
        return chooseDateFlag;
    }

    /**
     * 设置选择标识(为true日期选中，为false确定选中)
     *
     * @param chooseDateFlag 选择标识
     */
    public void setChooseDateFlag(boolean chooseDateFlag) {
        this.chooseDateFlag = chooseDateFlag;
    }

}
