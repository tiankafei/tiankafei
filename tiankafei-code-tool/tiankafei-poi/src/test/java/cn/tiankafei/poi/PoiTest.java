package cn.tiankafei.poi;

import cn.tiankafei.poi.model.WorkbookVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class PoiTest {

    @Test
    public void test01(){
        try {
            WorkbookVo workbookVo = new WorkbookVo();

            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(workbookVo);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
