package com.googlecode.aviator.runtime.function.system;

import com.googlecode.aviator.utils.LruMap;

import java.text.SimpleDateFormat;


/**
 * DateFormat cache
 *
 * @author boyan
 */
public class DateFormatCache {

    private static int maxSize =
            Integer.valueOf(System.getProperty("aviator.date_format.cache.max", "256"));

    private static ThreadLocal<LruMap<String, SimpleDateFormat>> formatCache =
            new ThreadLocal<LruMap<String, SimpleDateFormat>>();


    public static SimpleDateFormat getOrCreateDateFormat(String format) {
        LruMap<String/* format */, SimpleDateFormat> cache = formatCache.get();
        if (cache == null) {
            cache = new LruMap<String, SimpleDateFormat>(maxSize);
            formatCache.set(cache);
        }
        SimpleDateFormat rt = cache.get(format);
        if (rt == null) {
            rt = new SimpleDateFormat(format);
            cache.put(format, rt);
        }
        return rt;
    }

}
