package org.fightTiger.fighter.sample.common.util;

//import com.linkage.educloud.module.common.user.domain.LoginObject;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by LY on 14-3-27 上午11:37
 */
public class Test {

    public static int matchesPhoneNumber(String phone_number) {
        String cm = "^((13[4-9])|(147)|(15[0-2,7-9])|(18[2-3,7-8]))\\d{8}$";//移动
        String cu = "^((13[0-2])|(145)|(15[5-6])|(186))\\d{8}$";//联通
        String ct = "^((133)|(153)|(18[0,9]))\\d{8}$";//电信
        int flag;
        if (phone_number.matches(cm)) {
            flag = 1;
        } else if (phone_number.matches(cu)) {
            flag = 2;
        } else if (phone_number.matches(ct)) {
            flag = 3;
        } else {
            flag = 4;
        }
        return flag;

    }

    public static void whichOperator(int x) {
        switch (x) {
            case 1:
                System.out.println("移动号码");
                break;
            case 2:
                System.out.println("联通号码 ");
                break;
            case 3:
                System.out.println("电信号码");
                break;
            case 4:
                System.out.println("输入有误");
                break;
            default:
                System.out.println("输入有误");

        }
    }

    public static void main(String[] args) {
//        String e = "18012791770";
//        whichOperator(matchesPhoneNumber(e));

//        String temp="P02I01P01A01V1.0.0";
//        System.out.println(StringUtils.substring(temp,0,3));
//        System.out.println(StringUtils.substring(temp,3,6));
//        System.out.println(StringUtils.substring(temp,6));
//
//        Properties p=System.getProperties();
//        Set set=p.keySet();
//        for(Object key:set){
//            System.out.println(key+"="+p.get(key));
//        }
//String loginName="liuyang";
//        String pwd="haha";
//        String url="http://10.2.58.179:8080/educloudapi/crossapi/login?account=${loginName}&password=${pwd}";
//        url=StringUtils.replaceEach(url,new String[]{"${loginName}","${pwd}"},new String[]{loginName,pwd});
//        System.out.println(url);

//        String temp1="";
//        String temp2="555";
//        String temp3="5.5";
//        String temp4="0.4";
//        String temp5="5t3";
//        String temp6="7 ";
//        String temp7="5 5";
//        String temp8=" ";
//        String temp9="-34";
//        System.out.println(StringUtils.isNumeric(temp1));
//        System.out.println(StringUtils.isNumeric(temp2));
//        System.out.println(StringUtils.isNumeric(temp3));
//        System.out.println(StringUtils.isNumeric(temp4));
//        System.out.println(StringUtils.isNumeric(temp5));
//        System.out.println(StringUtils.isNumeric(temp6));
//        System.out.println(StringUtils.isNumeric(temp7));
//        System.out.println(StringUtils.isNumeric(temp8));
//        System.out.println(StringUtils.isNumeric(temp9));
//        System.out.println("fffffffffffffffffffffffffffff");
//        System.out.println(StringUtils.isNumericSpace(temp1));
//        System.out.println(StringUtils.isNumericSpace(temp2));
//        System.out.println(StringUtils.isNumericSpace(temp3));
//        System.out.println(StringUtils.isNumericSpace(temp4));
//        System.out.println(StringUtils.isNumericSpace(temp5));
//        System.out.println(StringUtils.isNumericSpace(temp6));
//        System.out.println(StringUtils.isNumericSpace(temp7));
//        System.out.println(StringUtils.isNumericSpace(temp8));
//        System.out.println(StringUtils.isNumericSpace(temp9));

//        String temp="2014-03-12";
//        try {
//            Date o=DateUtils.parseDate(temp,"yyyy-MM-dd");
//            System.out.println(o.toString());
//        }catch(ParseException e){
//            e.printStackTrace();
//        }


//        String regEx="(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
//        String str="2012-04-30";
//        boolean rs = Pattern.compile(regEx).matcher(str).find();
//        System.out.println(rs);

//        ArrayList list=new ArrayList();
//        list.add(0,10000);
//        list.add(1,3);
//        list.add(2,"2013-02-11");
//        Object[] o=list.toArray();
//        for(int i=0;i<o.length;i++){
//            System.out.println(o[i]);
//        }
//
//        String aa="  2012 -02-13  ";
//        String temp=StringUtils.trim(aa);
//        System.out.println(temp);

//        String temp="<script>alert('haha');</script>";
//        System.out.println(StringEscapeUtils.escapeEcmaScript(temp));
//        System.out.println(StringEscapeUtils.unescapeEcmaScript(temp));
//        System.out.println(StringEscapeUtils.escapeHtml4(temp));
//        System.out.println(StringEscapeUtils.unescapeHtml4(temp));


//        String temp="";
//        System.out.println(StringUtils.isBlank(""));
//        System.out.println(StringUtils.isBlank("  "));

//        String temp="12";
//        System.out.println(StringUtils.containsOnly(temp,'1','2'));


        String str="@@ly,hh@@ly1 jjj@ly2，急急急@ly3;jjj@ly4；急急急@ly5:jjj@ly6：@反反复复@ly7@ly8@jjjj ";

        List<String> list=WeiboUtil.getWeiboAT(str);
        for(String s:list){
            System.out.println(s);
        }

//        System.out.println(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date()));

        System.out.println(StringUtils.isNumeric("-43934"));

        String t=FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(t);
        try {
            Date date=(Date)FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").parseObject(t);
        }catch (Exception e){

        }


    }
}
