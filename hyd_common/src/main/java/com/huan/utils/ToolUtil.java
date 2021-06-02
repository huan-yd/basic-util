/**
 * Copyright (c) 2015-2016, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huan.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/**
 * 高频方法集合类
 */
public class ToolUtil {

    /**
     * 获取随机位数的字符串
     *
     * @author gobestsoft
     * @Date 2017/8/24 14:09
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取验证码
     * @param length
     * @return java.lang.String
     * @Date 2020/3/25 10:22
     */
    public static String getVerifyCode(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 字符串前补0
     * @param str		字符串
     * @param length	总长度
     * @return
     */
    public static String getStrWithZeroStart(String str,int length) {
    	String zero = "";
    	for (int i = 0; i < length; i++) {
			zero += "0";
		}
    	zero += str;
    	return zero.substring(zero.length()-length, zero.length());
    }

    /**
     * 判断一个对象是否是时间类型
     *
     * @author gobestsoft
     * @Date 2017/4/18 12:55
     */
    /*public static String dateType(Object o){
        if(o instanceof Date){
            return DateUtils.getDay((Date) o);
        }else{
            return o.toString();
        }
    }*/

    /**
     * 获取异常的具体信息
     *
     * @author gobestsoft
     * @Date 2017/3/30 9:21
     * @version 2.0
     */
    public static String getExceptionMsg(Exception e) {
        StringWriter sw = new StringWriter();
        try{
            e.printStackTrace(new PrintWriter(sw));
        }finally {
            try {
                sw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return sw.getBuffer().toString().replaceAll("\\$","T");
    }

    /**
     * 比较两个对象是否相等。<br>
     * 相同的条件有两个，满足其一即可：<br>
     * 1. obj1 == null && obj2 == null; 2. obj1.equals(obj2)
     *
     * @param obj1 对象1
     * @param obj2 对象2
     * @return 是否相等
     */
    public static boolean equals(Object obj1, Object obj2) {
        return (obj1 != null) ? (obj1.equals(obj2)) : (obj2 == null);
    }

    /**
     * 计算对象长度，如果是字符串调用其length函数，集合类调用其size函数，数组调用其length属性，其他可遍历对象遍历计算长度
     *
     * @param obj 被计算长度的对象
     * @return 长度
     */
    public static int length(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length();
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).size();
        }
        if (obj instanceof Map) {
            return ((Map<?, ?>) obj).size();
        }

        int count;
        if (obj instanceof Iterator) {
            Iterator<?> iter = (Iterator<?>) obj;
            count = 0;
            while (iter.hasNext()) {
                count++;
                iter.next();
            }
            return count;
        }
        if (obj instanceof Enumeration) {
            Enumeration<?> enumeration = (Enumeration<?>) obj;
            count = 0;
            while (enumeration.hasMoreElements()) {
                count++;
                enumeration.nextElement();
            }
            return count;
        }
        if (obj.getClass().isArray() == true) {
            return Array.getLength(obj);
        }
        return -1;
    }

    /**
     * 对象中是否包含元素
     *
     * @param obj     对象
     * @param element 元素
     * @return 是否包含
     */
    public static boolean contains(Object obj, Object element) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof String) {
            if (element == null) {
                return false;
            }
            return ((String) obj).contains(element.toString());
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).contains(element);
        }
        if (obj instanceof Map) {
            return ((Map<?, ?>) obj).values().contains(element);
        }

        if (obj instanceof Iterator) {
            Iterator<?> iter = (Iterator<?>) obj;
            while (iter.hasNext()) {
                Object o = iter.next();
                if (equals(o, element)) {
                    return true;
                }
            }
            return false;
        }
        if (obj instanceof Enumeration) {
            Enumeration<?> enumeration = (Enumeration<?>) obj;
            while (enumeration.hasMoreElements()) {
                Object o = enumeration.nextElement();
                if (equals(o, element)) {
                    return true;
                }
            }
            return false;
        }
        if (obj.getClass().isArray() == true) {
            int len = Array.getLength(obj);
            for (int i = 0; i < len; i++) {
                Object o = Array.get(obj, i);
                if (equals(o, element)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 对象是否不为空(新增)
     *
     * @param o String,List,Map,Object[],int[],long[]
     * @return
     */
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    /**
     * 对象是否为空
     *
     * @param o String,List,Map,Object[],int[],long[]
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            if (o.toString().trim().equals("")) {
                return true;
            }
        } else if (o instanceof List) {
            if (((List) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Map) {
            if (((Map) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Set) {
            if (((Set) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Object[]) {
            if (((Object[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof int[]) {
            if (((int[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof long[]) {
            if (((long[]) o).length == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象组中是否存在 Empty Object
     *
     * @param os 对象组
     * @return
     */
    public static boolean isOneEmpty(Object... os) {
        for (Object o : os) {
            if (isEmpty(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象组中是否全是 Empty Object
     *
     * @param os
     * @return
     */
    public static boolean isAllEmpty(Object... os) {
        for (Object o : os) {
            if (!isEmpty(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否为数字
     *
     * @param obj
     * @return
     */
    public static boolean isNum(Object obj) {
        try {
            Integer.parseInt(obj.toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 如果为空, 则调用默认值
     *
     * @param str
     * @return
     */
    public static Object getValue(Object str, Object defaultValue) {
        if (isEmpty(str)) {
            return defaultValue;
        }
        return str;
    }

    /**
     * 强转->long,并去掉多余空格
     *
     * @param str
     * @return
     */
    public static Long toLong(Object str) {
        if (null == str) {
            return null;
        }
        return Long.parseLong(str.toString().trim());
    }

    /**
     * 强转->int,并去掉多余空格
     *
     * @param str
     * @return
     */
    public static Integer toInt(Object str) {
        if (null == str) {
            return null;
        }
        return Integer.parseInt(str.toString().trim());
    }

    /**
     * 强转->string,并去掉多余空格
     *
     * @param str
     * @return
     */
    public static String toStr(Object str) {
        return toStr(str, "");
    }

    /**
     * 强转->string,并去掉多余空格
     *
     * @param str
     * @param defaultValue
     * @return
     */
    public static String toStr(Object str, String defaultValue) {
        if (null == str) {
            return defaultValue;
        }
        return str.toString().trim();
    }

    /**
     * 强转->int
     *
     * @param obj
     * @return
     */
//	public static int toInt(Object value) {
//		return toInt(value, -1);
//	}

    /**
     * 强转->int
     *
     * @param obj
     * @param defaultValue
     * @return
     */
//	public static int toInt(Object value, int defaultValue) {
//		return Convert.toInt(value, defaultValue);
//	}

    /**
     * 强转->long
     *
     * @param obj
     * @return
     */
//	public static long toLong(Object value) {
//		return toLong(value, -1);
//	}

    /**
     * 强转->long
     *
     * @param obj
     * @param defaultValue
     * @return
     */
//	public static long toLong(Object value, long defaultValue) {
//		return Convert.toLong(value, defaultValue);
//	}
//
//	public static String encodeUrl(String url) {
//		return URLKit.encode(url, CharsetKit.UTF_8);
//	}
//
//	public static String decodeUrl(String url) {
//		return URLKit.decode(url, CharsetKit.UTF_8);
//	}

    /**
     * map的key转为小写
     *
     * @param map
     * @return Map<String,Object>
     */
    public static Map<String, Object> caseInsensitiveMap(Map<String, Object> map) {
        Map<String, Object> tempMap = new HashMap<>();
        for (String key : map.keySet()) {
            tempMap.put(key.toLowerCase(), map.get(key));
        }
        return tempMap;
    }

    /**
     * 获取map中第一个数据值
     *
     * @param <K> Key的类型
     * @param <V> Value的类型
     * @param map 数据源
     * @return 返回的值
     */
    public static <K, V> V getFirstOrNull(Map<K, V> map) {
        V obj = null;
        for (Entry<K, V> entry : map.entrySet()) {
            obj = entry.getValue();
            if (obj != null) {
                break;
            }
        }
        return obj;
    }

    /**
     * 创建StringBuilder对象
     *
     * @return StringBuilder对象
     */
    public static StringBuilder builder(String... strs) {
        final StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb;
    }

    /**
     * 创建StringBuilder对象
     *
     * @return StringBuilder对象
     */
    public static void builder(StringBuilder sb, String... strs) {
        for (String str : strs) {
            sb.append(str);
        }
    }

    /**
     * 去掉指定后缀
     *
     * @param str    字符串
     * @param suffix 后缀
     * @return 切掉后的字符串，若后缀不是 suffix， 返回原字符串
     */
    public static String removeSuffix(String str, String suffix) {
        if (isEmpty(str) || isEmpty(suffix)) {
            return str;
        }

        if (str.endsWith(suffix)) {
            return str.substring(0, str.length() - suffix.length());
        }
        return str;
    }



    /**
     * 判断是否是windows操作系统
     *
     * @author gobestsoft
     * @Date 2017/5/24 22:34
     */
    public static Boolean isWinOs(){
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 获取临时目录
     *
     * @author gobestsoft
     * @Date 2017/5/24 22:35
     */
    public static String getTempPath(){
        return System.getProperty("java.io.tmpdir");
    }

    /**
     * 格式化菜单
     * @param val
     * @param ctx
     * @return
     */
    /*public static String parseUrl(String val, String ctx) {

    	if (StringUtils.startsWith(val, "http://") || StringUtils.startsWith(val, "https://")) {
    		return val;
    	}

    	return ctx + val;
    }*/

    /**
     * web转义字符转换
     */
    public static String parseHtmlStr(String value) {
        String ono = value.replaceAll("& ", "&");
        String result = org.springframework.web.util.HtmlUtils.htmlUnescape(ono);
        return result;
    }

    /**
     * 用于返回逗号拼接的字符串
     * @author swt
     * @param arr
     * @return
     */
    public static String arrayJoin(String arr[] ){
        return Arrays.toString(arr).replace("[","").replace("]","");
    }

    /**
     *转为驼峰
     * @param map
     */
    public static void transferKey(Map map){
        if(map==null||map.size()==0)return;
        Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
        Map temp = new HashMap();
        while (iterator.hasNext()){
            Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            if(key.contains("_")){
                String[] s = key.split("_");
                key = "";
                for(int i=0;i<s.length;i++ ){
                    if(i!=0){
                        s[i] = (s[i].charAt(0)+"").toUpperCase()+(s[i].length()>1?s[i].substring(1,s[i].length()):"");
                    }
                    key+=s[i];
                }
                temp.put(key,next.getValue());
                iterator.remove();
            }
        }
        map.putAll(temp);
    }

    public static void transferKey(List<Map<String,Object>> list){

        if(list==null||list.size()==0)return;
        list.forEach((Map map )->{
            Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
            Map temp = new HashMap();
            while (iterator.hasNext()){
                Entry<String, Object> next = iterator.next();
                String key = next.getKey();
                if(key.contains("_")){
                    String[] s = key.split("_");
                    key = "";
                    for(int i=0;i<s.length;i++ ){
                        if(i!=0){
                            s[i] = (s[i].charAt(0)+"").toUpperCase()+(s[i].length()>1?s[i].substring(1,s[i].length()):"");
                        }
                        key+=s[i];
                    }
                    temp.put(key,next.getValue());
                    iterator.remove();
                }
            }
            map.putAll(temp);

        });

    }

    /**
     * 校验身份证
     * @param certificateNum
     * @return
     */
    public static boolean validCertificateNum(String certificateNum){
        //第一代身份证正则表达式(15位)
        String isIDCard1 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";
        //第二代身份证正则表达式(18位)
        String isIDCard2 ="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[a-zA-Z])$";

        //验证身份证
        if (certificateNum.matches(isIDCard1) ) {
            return true;
        }
        if (certificateNum.matches(isIDCard2)) {

            return cardCodeVerify(certificateNum);
        }
        return false;
    }

    /**
     * 单独校验二代身份证
     * @param cardcode
     * @return
     */
    private static boolean cardCodeVerify(String cardcode) {
        int i = 0;
        String r = "error";
        String lastnumber = "";

        i += Integer.parseInt(cardcode.substring(0, 1)) * 7;
        i += Integer.parseInt(cardcode.substring(1, 2)) * 9;
        i += Integer.parseInt(cardcode.substring(2, 3)) * 10;
        i += Integer.parseInt(cardcode.substring(3, 4)) * 5;
        i += Integer.parseInt(cardcode.substring(4, 5)) * 8;
        i += Integer.parseInt(cardcode.substring(5, 6)) * 4;
        i += Integer.parseInt(cardcode.substring(6, 7)) * 2;
        i += Integer.parseInt(cardcode.substring(7, 8)) * 1;
        i += Integer.parseInt(cardcode.substring(8, 9)) * 6;
        i += Integer.parseInt(cardcode.substring(9, 10)) * 3;
        i += Integer.parseInt(cardcode.substring(10,11)) * 7;
        i += Integer.parseInt(cardcode.substring(11,12)) * 9;
        i += Integer.parseInt(cardcode.substring(12,13)) * 10;
        i += Integer.parseInt(cardcode.substring(13,14)) * 5;
        i += Integer.parseInt(cardcode.substring(14,15)) * 8;
        i += Integer.parseInt(cardcode.substring(15,16)) * 4;
        i += Integer.parseInt(cardcode.substring(16,17)) * 2;
        i = i % 11;
        lastnumber =cardcode.substring(17,18);
        if (i == 0) {
            r = "1";
        }
        if (i == 1) {
            r = "0";
        }
        if (i == 2) {
            r = "x";
        }
        if (i == 3) {
            r = "9";
        }
        if (i == 4) {
            r = "8";
        }
        if (i == 5) {
            r = "7";
        }
        if (i == 6) {
            r = "6";
        }
        if (i == 7) {
            r = "5";
        }
        if (i == 8) {
            r = "4";
        }
        if (i == 9) {
            r = "3";
        }
        if (i == 10) {
            r = "2";
        }
        if (r.equals(lastnumber.toLowerCase())) {
            return true;
        }
        return false;
    }

    /**
     * 手机号隐藏四位
     * @param number
     * @return
     */
    /*public static String hidePhone(String number){
        if(StringUtils.isEmpty(number)){
            return null;
        }
        String phoneNumber = number.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
        return phoneNumber;
    }*/

    /**
     * 姓名脱敏
     * @param name
     * @return
     */
    public static String hideName(String name){
        if(name.length()==2){
            name=name.substring(0,1)+'*' ;//截取name 字符串截取第一个字符，
        }else if(name.length()==3){
            name=name.substring(0,1)+"*"+name.substring(2,3);//截取第一个和第三个字符
        }else if(name.length()>3){
            name=name.substring(0,1)+"*"+'*'+name.substring(3,name.length());//截取第一个和大于第4个字符
        }
        return name;
    }

    /**
     * 身份证号隐藏
     * @param idCard
     * @return
     */
    /*public static String hideCertNum(String idCard){
        if(StringUtils.isEmpty(idCard)){
            return null;
        }
        //$1、$2、……表示正则表达式里面第一个、第二个、……括号里面的匹配内容
        String idCardNumber = idCard.replaceAll("(\\d{4})\\d{10}(\\w{4})","$1****$2");
        return idCardNumber;
    }*/

    /**
     * 批量生成 年龄区间
     * @param start
     * @param end
     * @return [{startDate:Str , endDate:Str , name:Str}]
     */
    /*public static List<Map<String,Object>> getAgeRange(int start,int end, int range){

        List<Map<String,Object>> list = new ArrayList<>();

        Calendar ca = Calendar.getInstance();

        ca.add(Calendar.YEAR,-end);//比如直接获取60年之前的日期

        Map<String,Object> last = new HashMap<>();

        last.put("name",end+"岁以上");

        last.put("endDate", DateUtils.getDay(ca.getTime()).replace("-",""));

        list.add(last);


        int count = (end - start) / range;


        int rest = (end - start)%range;

        if(count>0){
            for(int i = count;i> 0; i--){

                Map<String,Object> item = new HashMap<>();

                String name = end+"岁";

                item.put("startDate", DateUtils.getDay(ca.getTime()).replace("-",""));

                ca.add(Calendar.YEAR,range);

                item.put("endDate" , DateUtils.getDay(ca.getTime()).replace("-",""));

                end -= range;

                name = end+"-"+ name;

                item.put("name",name);

                list.add(item);


            }
        }
        if(rest >0){

            Map<String,Object> item = new HashMap<>();

            String name = start+"-"+end+"岁";

            item.put("name" , name);

            item.put("startDate" , DateUtils.getDay(ca.getTime()).replace("-",""));

            ca.add(Calendar.YEAR,rest);

            item.put("endDate", DateUtils.getDay(ca.getTime()).replace("-",""));

            list.add(item);
        }

        Collections.reverse(list);

        return list;

    }*/

    /**
     * 根据字典的value 转为对应的汉字
     *
     * @param allDict
     * @param dictValue
     * @param dictType
     * @return
     */
    /*public static String getDictName(List<DictRedisDTO> allDict, String dictValue, String dictType) {
        for (DictRedisDTO dictRedisDTO : allDict) {
            if (dictRedisDTO.getDictType().equals(dictType)) {
                for (DictRedisDTO dictChild : dictRedisDTO.getChildren()) {
                    if (dictChild.getDictValue().equals(dictValue)) {
                        return dictChild.getDictName();
                    }
                }
            }
        }
        return null;
    }*/

    /**
     * 根据字典的value 转为对应的备注，干部工会层次会用到
     *
     * @param allDict
     * @param dictValue
     * @param dictType
     * @return
     */
    /*public static String getDictRemark(List<DictRedisDTO> allDict, String dictValue, String dictType) {
        for (DictRedisDTO dictRedisDTO : allDict) {
            if (dictRedisDTO.getDictType().equals(dictType)) {
                for (DictRedisDTO dictChild : dictRedisDTO.getChildren()) {
                    if (dictChild.getDictValue().equals(dictValue)) {
                        return dictChild.getRemark();
                    }
                }
            }
        }
        return null;
    }*/

    /**
     * 根据对应的汉字找到字典的value
     *
     * @param allDict
     * @param dictName
     * @param dictType
     * @return
     */
    /*public static DictRedisDTO getDictValue(List<DictRedisDTO> allDict, String dictName, String dictType) {
        for (DictRedisDTO dictRedisDTO : allDict) {
            if (dictRedisDTO.getDictType().equals(dictType)) {
                for (DictRedisDTO dictChild : dictRedisDTO.getChildren()) {
                    if (StringUtils.trim(dictChild.getDictName()).equals(StringUtils.trim(dictName))) {
                        return dictChild;
                    }
                }
            }
        }
        return null;
    }*/

    /**
     * 根据汉字备注转为数字，主要用于公会层次
     *
     * @param allDict
     * @param remark
     * @param dictType
     * @return
     */
    /*public static DictRedisDTO getDictValueByRemark(List<DictRedisDTO> allDict, String remark, String dictType) {
        for (DictRedisDTO dictRedisDTO : allDict) {
            if (dictRedisDTO.getDictType().equals(dictType)) {
                for (DictRedisDTO dictChild : dictRedisDTO.getChildren()) {
                    if (dictChild.getRemark().equals(remark)) {
                        return dictChild;
                    }
                }
            }
        }
        return null;
    }*/

    /**
     * 校验手机号
     * @version 1.0
     * @create time 2020/11/16 14:58
     */
    public static boolean validateMobile(String mobile){
        String reg = "1[3-9]{1}[0-9]{9}";
        boolean matches = Pattern.matches(reg, mobile);
        return matches;
    }

    public static void main(String[] args) {
        //System.out.println(validateMobile("19990928374"));
        System.out.println(validCertificateNum("36250119620124041X"));
    }
}
