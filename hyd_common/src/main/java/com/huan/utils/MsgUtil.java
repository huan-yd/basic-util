package com.huan.utils;


import com.huan.enums.MsgCommonEnum;

/**
 * 消息通用类
 *
 * @author lzh
 * @version V2.0
 * @since JDK 1.7
 */
public class MsgUtil {

    /**
     * 私有构造
     */
    private MsgUtil() {

    }

    /**
     * 消息解析器
     *
     * @param msg  定义消息
     * @param args 用户参数
     * @return 处理消息
     */
    private static String makeMsg(String msg, String... args) {
        if (msg.contains("{}") && args != null) {
            int cont = args.length;
            for (int i = 0; i < cont && msg.contains("{}") && args[i] != null; i++) {
                msg.replaceFirst("\\{\\}", args[i]);
            }
            return msg;
        } else {
            return msg;
        }
    }

    public static String createMsg(MsgCommonEnum msgCommonEnum, String... args) {
        return makeMsg(msgCommonEnum.value(), args);
    }

}
