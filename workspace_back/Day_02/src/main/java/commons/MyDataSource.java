package commons;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyDataSource {
    private static BasicDataSource basicDataSource = null;
    private static void setBasicDataSource(String fileName) throws NamingException {
        Properties properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream(fileName)){
            properties.load(fileInputStream);
        } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Context initialContext = new InitialContext();
        basicDataSource = (BasicDataSource)initialContext.lookup("java:/comp/env/jdbc/mysql");
//        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(properties.getProperty("url"));
        basicDataSource.setUsername(properties.getProperty("id"));
        basicDataSource.setPassword(properties.getProperty("pw"));
        basicDataSource.setInitialSize(Integer.parseInt(properties.getProperty("pool_size")));
        basicDataSource.setDefaultAutoCommit(Boolean.parseBoolean(properties.getProperty("default_auto_commit")));
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }

    private MyDataSource(){}
    public synchronized static BasicDataSource getBasicDataSource(String fileName) {
        if (basicDataSource == null) {
            try {
                setBasicDataSource(fileName);
            } catch (NamingException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        return basicDataSource;
    }
}
