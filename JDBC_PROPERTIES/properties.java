
package JDBC_PROPERTIES;

import java.io.*;
import java.util.Properties;

public class properties {
    public static void main(String[] args) throws Exception  {

        FileInputStream fs = new FileInputStream("C:\\fun with JAVA\\JDBC_Properties\\Application.properties");
        Properties properties = new Properties();
        properties.load(fs);

        String url = properties.getProperty("url");
        String name = properties.getProperty("name");
        String pass = properties.getProperty("pass");
        System.out.println( "URL is = "+url);
        System.out.println( "Name is = "+name);
        System.out.println( "password is = "+pass);

    }
}
