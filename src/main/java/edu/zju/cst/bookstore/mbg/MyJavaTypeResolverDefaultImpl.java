package edu.zju.cst.bookstore.mbg;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;


/**
 * @author 方康华
 * @description 自定义全局类型转化，将tinyint类型转化成Integer类型
 * @date 2019/10/3 10:58
 */
public class MyJavaTypeResolverDefaultImpl extends JavaTypeResolverDefaultImpl {
    public MyJavaTypeResolverDefaultImpl() {
        super();
        super.typeMap.put(-6, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Integer.class.getName())));
    }
}
