package edu.zju.cst.bookstore.mbg;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

/**
 * @author 方康华
 * @description 负责自动生成包含Swagger注解的model和mapper类注释
 * @date 2019/8/17 10:59
 */
public class MyCommentGenerator implements CommentGenerator {

    private static final String EXAMPLE_SUFFIX="Example";
    private static final String API_MODEL_PROPERTY_FULL_CLASS_NAME="io.swagger.annotations.ApiModelProperty";

    /**
     * 配置文件中的属性列表
     */
    private Properties properties;

    /**
     * 系统配置属性列表
     */
    private Properties systemProperties;

    /**
     * 是否自定义时间
     */
    private boolean suppressDate;

    /**
     * 是否自定义所有注释
     */
    private boolean suppressAllComments;

    /**
     * 是否在注释中加入数据库备注
     */
    private boolean addRemarkComments;

    /**
     * 日期格式
     */
    private SimpleDateFormat dateFormat;

    /**
     * 构造函数
     */
    public MyCommentGenerator() {
        super();
        properties = new Properties();
        systemProperties = System.getProperties();
        suppressDate = false;
        suppressAllComments = false;
        addRemarkComments = false;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    /**
     * 读取generatorConfig.xml配置文件中的属性列表
     * @param properties
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        this.suppressDate = StringUtility.isTrue(properties.getProperty("suppressData"));
        this.suppressAllComments = StringUtility.isTrue(properties.getProperty("suppressAllComments"));
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
        String dateFormatString = properties.getProperty("dateFormat");
        if(StringUtility.stringHasValue(dateFormatString)) {
            this.dateFormat = new SimpleDateFormat(dateFormatString);
        }
    }

    /**
     * 添加model的域（变量/属性）注释
     * @param field
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if(!suppressAllComments) {
            String remarks = introspectedColumn.getRemarks();
            System.out.println("introspectedColumn: " + introspectedColumn);
            System.out.println("introspectedTable: " + introspectedTable);
            System.out.println("remarks: " + remarks);
            // 根据配置参数和备注信息判断是否添加备注信息
            if(addRemarkComments && StringUtility.stringHasValue(remarks)) {
                String[] remarkLines;
                StringBuilder line = new StringBuilder();
                if(remarks.contains("\r\n")) {
                    remarkLines = remarks.split("\r\n");
                }
                else if(remarks.contains("\n")) {
                    remarkLines = remarks.split("\n");
                }
                else {
                    remarkLines = remarks.split("\r");
                }
                for(String remarkLine: remarkLines){
                    line.append(remarkLine);
                }
                System.out.println(line);
                field.addJavaDocLine("@ApiModelProperty(value = \"" + line + "\")");
            }
        }
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
    }

    /**
     * model类注释
     * @param topLevelClass
     * @param introspectedTable
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    }

    /**
     * 增加mapper接口的类注释
     * @param innerClass
     * @param introspectedTable
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean b) {
    }

    /**
     * Enum类注释
     * @param innerEnum
     * @param introspectedTable
     */
    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    }

    /**
     * mapper接口中的方法注释
     * @param method
     * @param introspectedTable
     */
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
    }

    /**
     * 增加Java文件注释
     * @param compilationUnit
     */
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        if(!this.suppressAllComments) {
            compilationUnit.addFileCommentLine("/**");
            compilationUnit.addFileCommentLine(" * " + compilationUnit.getType().getShortName() + ".java");
            compilationUnit.addFileCommentLine(" * Copyright(C) 2019 popo_fkh");
            compilationUnit.addFileCommentLine(" * @date " + getDateString());
            compilationUnit.addFileCommentLine(" */");

            //只在model中添加swagger注解类的导入
            if(!compilationUnit.isJavaInterface()&&!compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)){
                compilationUnit.addImportedType(new FullyQualifiedJavaType(API_MODEL_PROPERTY_FULL_CLASS_NAME));
            }
        }
    }

    /**
     * mapper.xml文件的注释
     * @param xmlElement
     */
    @Override
    public void addComment(XmlElement xmlElement) {
    }

    @Override
    public void addRootComment(XmlElement xmlElement) {
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {
    }

    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {
    }

    private String getDateString() {
        if (this.suppressDate) {
            return null;
        } else {
            return this.dateFormat != null ? this.dateFormat.format(new Date()) : (new Date()).toString();
        }
    }
}

