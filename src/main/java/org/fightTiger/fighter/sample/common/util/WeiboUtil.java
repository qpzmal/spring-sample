package org.fightTiger.fighter.sample.common.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 微博工具类 on 14-7-31.
 */
@Component
public class WeiboUtil {

    @Autowired
    private Properties appProps;



    final static Logger logger = LoggerFactory.getLogger(WeiboUtil.class);

    private static Pattern AT_PATTERN = Pattern.compile("@((\\p{Alnum}|[\\u4e00-\\u9fa5])+)[ |,|:|;|，|：|；|@|\\s]{1}");
    private static Pattern AT_PATTERN_TAG = Pattern.compile("<user>([^<|^>]*)</user>");

    static List<String> regxp(Pattern pattern, String value){
        List<String> result = new ArrayList<String>();
        Matcher m = pattern.matcher(value);
        while (m.find()){
            result.add(m.group(1));
        }
        return result;
    }

    public static List<String> getWeiboAT(String content) {
        return regxp(AT_PATTERN, content);
    }

    public static List<String> getWeiboAtTag(String content) {
        return regxp(AT_PATTERN_TAG, content);
    }

    //替换微博内容中的@链接
    public String getReturnWeiBoContent(String content) {
        List<String> weiboATList = getWeiboATSingle(content);
        if (weiboATList.size() > 0) {
            for (String aWeiboATList : weiboATList) {
                content = replaceATcontent(content, aWeiboATList);
            }
        }
        content = FaceExpression.filter(content, appProps.getProperty("educloud.domain.url"));
        return content;
    }

    //为微博内容中的@增加链接
    public String replaceATcontent(String content,  String userName) {
//        String[] arry = userName.split(",");
//        String ATUser = arry[0];
//        User user = pwDao.selectUserByNIckName(ATUser);
//        long userId = 0;
//        if (user != null) {
//            userId = user.getId();
//            String path = appProps.getProperty("educloud.domain.url");
//            String httpUrl = path + "/person/index/" + userId;
//            return content.replaceFirst("@" + ATUser, "<a class=\"name\" href='" + httpUrl + "'>" + "@" + userName.trim() + "</a>");
//        }
//        return content.replaceFirst("@" + ATUser,  "@" + userName.trim());
        return "";
    }

    public static List<String> getWeiboATSingle(String content) {
        List<String> weiboATList = getWeiboAT(content);
        List<String> atList = new ArrayList<String>();
        for (String userName : weiboATList) {
            if (!atList.contains(userName)) {
                atList.add(userName);
            }
        }
        return atList;
    }
}