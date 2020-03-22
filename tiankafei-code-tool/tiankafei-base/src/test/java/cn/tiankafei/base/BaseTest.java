package cn.tiankafei.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class BaseTest {

    @Test
    public void testForIterator(){
        List dataList = new ArrayList<>();
        dataList.add(1);
        dataList.add(3);
        dataList.add(2);
        for (Iterator iterator = dataList.listIterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

}
