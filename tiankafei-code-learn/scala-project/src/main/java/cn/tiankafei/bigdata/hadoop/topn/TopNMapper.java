package cn.tiankafei.bigdata.hadoop.topn;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class TopNMapper extends Mapper<LongWritable, Text, TopNKey, IntWritable> {

    private TopNKey mapKey = new TopNKey();
    private IntWritable mapValue = new IntWritable();
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Calendar calendar = Calendar.getInstance();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 2019-6-1 22:22:22	1	39
        String[] arr = StringUtils.split(value.toString(), '\t');

        try {
            Date date = formatter.parse(arr[0]);
            calendar.setTime(date);

            int year = calendar.get(Calendar.YEAR);
            int monthValue = calendar.get(Calendar.MONTH) + 1;
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            int wd = Integer.valueOf(arr[2]);

            mapKey.setYear(year).setMonth(monthValue).setDay(dayOfMonth).setWd(wd);
            mapValue.set(wd);
            context.write(mapKey, mapValue);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
