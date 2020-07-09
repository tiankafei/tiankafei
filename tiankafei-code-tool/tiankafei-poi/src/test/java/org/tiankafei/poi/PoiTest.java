package org.tiankafei.poi;

import org.tiankafei.poi.property.impl.WorkbookBeanInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class PoiTest {

    @Test
    public void test01() {
        try {
            WorkbookBeanInfo workbookVo = new WorkbookBeanInfo();

            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(workbookVo);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
