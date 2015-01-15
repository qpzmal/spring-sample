package org.fightTiger.fighter.sample.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by LY on 14-3-27 上午11:37
 */
public class Utils {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    //模糊查询时特殊字符的转义
    public static String escapeForSpecialChar(String content) {
        if (StringUtils.isBlank(content)) {//为空，返回空
            return "";
        }
        content = content.replace("\\", "\\\\");// 转义前的字符串不为空，执行替换操作
        content = content.replace("%", "\\%");
        content = content.replace("_", "\\_");
        return content;
    }

    /*按字节长度截取字符串 
        * @param str 将要截取的字符串参数
		* @param toCount 截取的字节长度 
		* @param more 字符串末尾补上的字符串 
		* @return 返回截取后的字符串 
	*/
    public static String substring(String str, int toCount, String more) {
        if (StringUtils.isBlank(str)) {//若字符串为空，直接返回
            return "";
        }
        if (str.trim().getBytes().length <= toCount) {//截取的字节长度大于字符串字节长度，直接返回
            return str;
        }
        int loop = 0;
        StringBuffer stringBuffer = new StringBuffer();
        char[] tempChar = str.toCharArray();
        for (int i = 0; i < tempChar.length && toCount > loop; i++) {//根据字符串字节获取截取后字符串
            String tmp = str.valueOf(tempChar[i]);
            byte[] b = tmp.getBytes();
            loop += b.length;
            stringBuffer.append(tempChar[i]);//
        }
        if (toCount == loop || (toCount == loop - 1)) {//添加末尾字符串
            stringBuffer.append(more);
        }
        return stringBuffer.toString();
    }

    //获取访问者IP
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取字符串的长度，如果有中文，则每个中文字符计为2位
     *
     * @param value 指定的字符串
     * @return 字符串的长度
     */
    public static int getStrlength(String value) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < value.length(); i++) {
            /* 获取一个字符 */
            String temp = value.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                valueLength += 2;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }

    public static <T> T getJsonObject(String json, Class<T> beanClass) throws Exception {
        return new ObjectMapper().readValue(json, beanClass);
    }

    /*
     * 时分、昨天 前天、日期
	 */
    public static String findTimeDiff(String time) {
        try {
            Calendar c = Calendar.getInstance();// 带时分秒的值
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df3 = new SimpleDateFormat("yy-MM-dd");
            long s = df1.parse(time).getTime();
            long e = df1.parse(df1.format(c.getTime())).getTime();
            if (e == s) {// 今天
                SimpleDateFormat df2 = new SimpleDateFormat("HH:mm");
                return df2.format(df.parse(time));
            } else if ((e - s) / (3600000 * 24) == 1) {// 昨天
                return "昨天 ";
            } else if ((e - s) / (3600000 * 24) == 2) {// 前天
                return "前天";
            } else {
                return df3.format(df1.parse(time));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "未知时间";
        }
    }

    // 获取时间差方法  by liuyang
	/*
	 * 昨天 刚刚 1分钟内 分钟 1小时内 几小时 今天 日期
	 */
    public static String changeTimeDiff(String time) {
        try {
            Calendar c = Calendar.getInstance();// 带时分秒的值
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
            long s = df1.parse(time).getTime();
            long e = df1.parse(df1.format(c.getTime())).getTime();
            if (e == s) {// 今天
                SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long timeLong = c.getTimeInMillis() - df2.parse(time).getTime();
                int b = (int) timeLong / 1000;
                if (b < 1) {
                    return "刚刚";
                } else if (1 <= b && b < 60) {
                    return b + "秒之前";
                } else if (b < 3600 && b >= 60) {
                    // //精确到分钟
                    return ((int) b / 60) + "分钟之前";
                } else if (b < 3600 * 24 && b >= 3600) {
                    // //精确到小时
                    return ((int) b / 3600) + "小时之前";
                } else {
                    return "未知时间";
                }
            } else if ((e - s) / (3600000 * 24) == 1) {// 昨天
                return "昨天 ";
            } else if ((e - s) / (3600000 * 24) == 2) {// 前天
                return "前天";
            } else {// 前天
                SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return df1.format(df2.parse(time));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "未知时间";
        }
    }

    public static Random _random = new Random();
    /**
     * 生成随机数 param length 随机数长度，长度不能大于10
     * @return String
     */
    public static String randomNum() {
        int x = _random.nextInt(999999);
        String wholeNum = ("000000" + x);
        return wholeNum.substring(wholeNum.length() - 6, wholeNum.length());
    }
}
