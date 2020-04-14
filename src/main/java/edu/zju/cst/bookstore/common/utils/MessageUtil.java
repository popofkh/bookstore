package edu.zju.cst.bookstore.common.utils;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author 方康华
 * @description 读取配置文件工具类
 * @date 2019/10/6 21:33
 */
@Component
public final class MessageUtil {

    private static Map<String, String> message = new HashMap<>();

    private static final String PROPERTIES_PATH = "/i18n/";
    private static final String PROPERTIES_FILE_NAME = "message";
    private static final String PROPERTIES_FILE_POSTFIX = ".properties";

    static {
        try {
            InputStream in = MessageUtil.class.getResourceAsStream(PROPERTIES_PATH + PROPERTIES_FILE_NAME + PROPERTIES_FILE_POSTFIX);
            Properties properties = new Properties();
            properties.load(in);
            Enumeration<?> enumeration = properties.propertyNames();
            while(enumeration.hasMoreElements()) {
                String key = (String) enumeration.nextElement();
                String value = properties.getProperty(key);
                message.put(key, value);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static String getMessage(String key) {
        return message.get(key);
    }

    public static void main(String[] args) {
        System.out.println(message.get("Organization.NotFount"));
    }
}
