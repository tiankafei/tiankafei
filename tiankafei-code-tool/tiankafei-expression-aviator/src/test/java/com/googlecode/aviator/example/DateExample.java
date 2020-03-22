package com.googlecode.aviator.example;

import com.googlecode.aviator.AviatorEvaluator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class DateExample {
    public static void main(String[] args) throws Exception {
        Map<String, Object> env = new HashMap<String, Object>();
        final Date date = new Date();
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(date);
        env.put("date", date);
        env.put("dateStr", dateStr);

        Boolean result = (Boolean) AviatorEvaluator.execute("date==dateStr", env);
        System.out.println(result);

        result = (Boolean) AviatorEvaluator.execute("date > '2009-12-20 00:00:00:00' ", env);
        System.out.println(result);

        result = (Boolean) AviatorEvaluator.execute("date < '2200-12-20 00:00:00:00' ", env);
        System.out.println(result);

        result = (Boolean) AviatorEvaluator.execute("date ==date ", env);
        System.out.println(result);
    }

}
