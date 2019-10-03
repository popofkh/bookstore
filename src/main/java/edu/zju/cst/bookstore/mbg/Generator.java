package edu.zju.cst.bookstore.mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 方康华
 * @description MyBatis代码生成器，运行该类，可自动生成mapper和model
 * @date 2019/8/8 19:06
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        // MBG执行过程中的警告信息
        List<String> warnings = new ArrayList<>();

        // 当生成的代码重复时，覆盖原代码
        boolean overwrite = true;

        // 读取MBG配置文件
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        // 创建MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        // 执行生成代码
        myBatisGenerator.generate(null);
        // 输出警告信息
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}

