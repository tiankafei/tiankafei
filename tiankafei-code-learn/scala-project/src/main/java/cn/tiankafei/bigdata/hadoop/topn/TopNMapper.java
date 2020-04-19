package cn.tiankafei.bigdata.hadoop.topn;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class TopNMapper extends Mapper<LongWritable, Text, TopNKey, IntWritable> {

    private TopNKey mapKey = new TopNKey();
    private IntWritable mapValue = new IntWritable();
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Calendar calendar = Calendar.getInstance();

    private Map<String, String> dictMap = new HashMap<>();

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        URI[] cacheFiles = context.getCacheFiles();
        Path path = new Path(cacheFiles[0].getPath());

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(new File(path.getName()));
            bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while((line = bufferedReader.readLine()) != null){
                String[] split = StringUtils.split(line, '\t');
                dictMap.put(split[0], split[1]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                fileReader.close();
            }
            if(bufferedReader != null){
                bufferedReader.close();
            }
        }
    }

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

            mapKey.setYear(year).setMonth(monthValue).setDay(dayOfMonth).setWd(wd).setLocation(dictMap.get(arr[1]));
            mapValue.set(wd);
            context.write(mapKey, mapValue);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
