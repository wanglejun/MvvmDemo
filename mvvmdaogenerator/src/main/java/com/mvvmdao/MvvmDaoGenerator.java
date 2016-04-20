package com.mvvmdao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * GreenDao数据库生成器
 */
public class MvvmDaoGenerator {
    public static void main(String[] args) throws Exception {
        // 正如你所见的，你创建了一个用于添加实体（Entity）的模式（Schema）对象。
        // 两个参数分别代表：数据库版本号与自动生成代码的包路径。
        Schema schema = new Schema(2, "com.mvvmdao.greendao");
//      指定生成的 Bean 与 DAO 类所在的目录，
//      Schema schema = new Schema(1, "com.mvvmdao.bean");
//      schema.setDefaultJavaPackageDao("com.mvvmdao.dao");

        // 模式（Schema）同时也拥有两个默认的 flags，分别用来标示 entity 是否是 activie 以及是否使用 keep sections。
        // schema2.enableActiveEntitiesByDefault();
        // schema2.enableKeepSectionsByDefault();

        //通过次Schema对象添加的所有实体都不会覆盖自定义的代码
        schema.enableKeepSectionsByDefault();

        // 添加实体（Entities）了。
        addUserInfo(schema);

        // 使用 DAOGenerator 类的 generateAll() 方法自动生成代码，此处你需要根据自己的情况更改输出目录（既之前创建的 java-gen)。
        new DaoGenerator().generateAll(schema, "/Users/wanglejun/AndroidStudioProjects/MvvmDemo/app/src/main/java-gen");
//        new DaoGenerator().generateAll(schema, "E:\\android\\studio\\MvvmDemo\\app\\src\\main\\java-gen\\");
    }

    public static void addUserInfo(Schema schema){
        Entity userInfo = schema.addEntity("UserInfo");
        userInfo.addStringProperty("objectId").primaryKey().notNull();
        userInfo.addStringProperty("username").notNull();
        userInfo.addStringProperty("password").notNull();
        userInfo.addStringProperty("cteatAt").notNull();
    }
}
