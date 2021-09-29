package com.huan.annotationtest;

import com.huan.annotationtest.annotation.Column;
import com.huan.annotationtest.annotation.Table;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author YueDong Huan
 * @Date 2021/6/2
 * @Email huanyued@163.com
 */
public class AnnotationParser {

    public static String assembleSqlFromObj(Object obj) {
        Table table = obj.getClass().getAnnotation(Table.class);
        StringBuffer sbSql = new StringBuffer();
        String tableName = table.tableName();
        sbSql.append("select * from " + tableName + " where 1=1 ");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field  field:fields) {
            String fieldName = field.getName();
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);
            try {
                Column column = field.getAnnotation(Column.class);
                if (column != null) {
                    Method method = obj.getClass().getMethod(methodName);
                    Object v = method.invoke(obj);
                    if (v != null) {
                        if (v instanceof String) {
                            String value = v.toString().trim();
                            // 判断参数是不是 in 类型参数 1,2,3
                            if (value.contains(",")) {
                                //去掉value中的,
                                String sqlParams = value.replace(",", "").trim();
                                //value中都是纯数字
                                if(isNum(sqlParams)){
                                    sbSql.append(" and " + column.columnName() + " in (" + value + ") ");
                                }else{
                                    String[] split = value.split(",");
                                    //将value重置为空
                                    value = "";
                                    for(int i = 0; i < split.length - 1; i++){
                                        value += "'"+split[i]+"',";
                                    }
                                    value += "'"+split[split.length - 1]+"'";
                                    sbSql.append(" and " + column.columnName() + " in (" + value + ") ");
                                }
                            } else {
                                if(value != null && value.length() > 0){
                                    sbSql.append(" and " + column.columnName() + " like '%" + value + "%' ");
                                }
                            }
                        } else {
                            sbSql.append(" and " + column.columnName() + "=" + v.toString() + " ");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sbSql.toString();
    }

    /**
     * 检查给定的值是不是 id 类型 1.检查字段名称 2.检查字段值
     *
     * @param target
     * @return
     */
    public static boolean isNum(String target) {
        boolean isNum = false;
        if (target.toLowerCase().contains("id")) {
            isNum = true;
        }
        if (target.matches("\\d+")) {
            isNum = true;
        }
        return isNum;
    }

}
