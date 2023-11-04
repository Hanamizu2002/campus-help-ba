package cn.hanamizu.campushelpba.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DruidUtil {
    private static DataSource dataSource;
    //通过静态代码块
    static {
        try {
            //1. 创建Properties对象
            Properties properties = new Properties();
            //2. 将配置文件转换成字节输入流
            InputStream is = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            //3. 使用properties对象加载输入流
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}

