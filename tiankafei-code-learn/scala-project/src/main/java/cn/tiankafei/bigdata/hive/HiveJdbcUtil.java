package cn.tiankafei.bigdata.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class HiveJdbcUtil {

    public static void main(String[] args) throws Exception {
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = DriverManager.getConnection("jdbc:hive2://bigdata03:10000/default", "root", "tiankafei");
        Statement stmt = conn.createStatement();
        String sql = "select * from oxox";
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {
            System.out.println(res.getString(1) + "-" + res.getString("name"));
        }
    }

}
