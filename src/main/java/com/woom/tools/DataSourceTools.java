package com.woom.tools;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import org.apache.commons.dbcp.BasicDataSource;

import java.io.StringReader;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

/**
 * Created by yuhao.zx on 15-9-23.
 */
public class DataSourceTools {

    public static void main(String[] args) {
//        String sql = "select *,name";
//        CCJSqlParserManager parserManager = new CCJSqlParserManager();
//        PlainSelect plainSelect  ;
//        try {
//            plainSelect = (PlainSelect) ((Select) parserManager.parse(new StringReader(sql))).getSelectBody();
////            System.out.println(plainSelect.getFromItem().toString());
////            System.out.println(plainSelect.getWhere().toString());
//            System.out.println(plainSelect.getSelectItems().toString());
//
//        } catch (JSQLParserException e) {
//            e.printStackTrace();
//        }
//        System.out.println(        remove0156OfAliPayId1("1231015623213101356")        );

        System.out.println("[{\"code\": \"picH5\",\"name\": \"pc入口图\",\"mustInput\": 1, \"width\": 1080, \"height\": 100, \"pattern\": \"^[a-z]{10}$\"},\n{\"code\": \"remark\",\"name\": \"备注信息\",\"mustInput\": 1,\"max-length\": 100}]\n".length());
    }

    public static String remove0156OfAliPayId1(String accountNO){

        if(accountNO != null && accountNO.endsWith("0156")){
            return accountNO.substring(0,accountNO.length()-4);
        }
        return  accountNO;

    }

    public static Long remove0156OfAliPayId(String accountNO){

        if(accountNO != null && accountNO.endsWith("0156")){
            return Long.valueOf(accountNO.substring(0,accountNO.length()-4));
        }
        return  Long.valueOf(accountNO);

    }
    public void getCloumn(){
        BasicDataSource b = (BasicDataSource)TestContext.getBean("dataSource");
        try{
            DatabaseMetaData dmd = b.getConnection().getMetaData();
            ResultSet resultSet = dmd.getColumns(b.getConnection().getCatalog(),"%","dayreport","%");
            System.out.println(b.getConnection().getCatalog());
            while(resultSet.next()){
                String columnName = resultSet.getString("COLUMN_NAME");
                String columnType = resultSet.getString("TYPE_NAME");
                System.out.println(columnName+"-->"+columnType);
            }
            System.out.println("hehe");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getCause());
            System.out.println("hehe");
        }
    }

}
