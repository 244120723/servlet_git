package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
* 连接数据的类
* */
public class DBUtil {
    private static String username;
    private static String password;
    private static String url;
    private static String driver;

    static {

        try {

            InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
           // FileInputStream in=new FileInputStream("db.properties");
            Properties p = new Properties();
            p.load(in);

            username = p.getProperty("db.username");
            password = p.getProperty("db.password");
            url = p.getProperty("db.url");
            driver = p.getProperty("db.driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //封装一个连接方法
    public static Connection getConn() {
        Connection conn = null;
        //加载驱动
        try {
            try {
                Class.forName(driver);
                try {
                    conn = DriverManager.getConnection(url, username, password);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  conn;
    }
}
