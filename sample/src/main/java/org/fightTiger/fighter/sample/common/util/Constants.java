package org.fightTiger.fighter.sample.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LY on 14-3-27 上午11:37
 */
public class Constants {

    //班级动态的大类型分为：原创类(ORIGINAL)、转发类(TRANSPOND)、分享类(SHARE)，原创类使用100-199的区间，转发类使用200-299的区间，分享类使用300-399的区间
//    public static int ORIGINAL_CLASS_ACTION_UPLOAD_SINGLE_PHOTO=100201; // 上传单张照片
//    public static int ORIGINAL_CLASS_ACTION_UPLOAD_BATCH_PHOTO=100202; // 上传多张照片
//    public static int ORIGINAL_CLASS_ACTION_PUBLISH_DIARY=100101; // 发表日记
//    public static int ORIGINAL_CLASS_ACTION_PUBLISH_WEIBO=100501; // 发表微博
//    /**
//     * 上传单个共享
//     */
//    public static int ORIGINAL_CLASS_ACTION_UPLOAD_SINGLE_SHARE=104;
//    /**
//     * 上传多个共享(建议禁止用户上传多个共享)
//     */
//    public static int ORIGINAL_CLASS_ACTION_UPLOAD_BATCH_SHARE=105;

    public static final int SYS_CLASSSPACE=1001;   // 动态归属系统类型-班级空间
    public static final int SYS_PERSONCENTER=1002; // 动态归属系统类型-个人中心
    public static final int SYS_RESOURCE=1003;     // 动态归属系统类型-资源

    public static final int MODULE_TYPE_CLASS_DAILY=2001;     // 动态归属模块类型-班级日志
    public static final int MODULE_TYPE_CLASS_PHOTO=2002;     // 动态归属模块类型-班级相册
    public static final int MODULE_TYPE_CLASS_NOTICE=2003;    // 动态归属模块类型-班级公告
    public static final int MODULE_TYPE_CLASS_HONOR=2004;     // 动态归属模块类型-班级荣誉
    public static final int MODULE_TYPE_CLASS_WEIBO=2005;     // 动态归属模块类型-班级微博

    public static final int OPTCATEGORY_CLASS_DAILY_PUBLISH=3001;     // 动态类别-写班级日志
    public static final int OPTCATEGORY_CLASS_DAILY_SHARE=3002;     // 动态类别-分享班级日志
    public static final int OPTCATEGORY_CLASS_PHOTO_UPLOAD_SINGLE=3003;     // 动态类别-上传单张照片
    public static final int OPTCATEGORY_CLASS_PHOTO_UPLOAD_BATCH=3004;     // 动态类别-上传多张照片
    public static final int OPTCATEGORY_CLASS_NOTICE_PUBLISH=3005;    // 动态类别-发布班级公告
    public static final int OPTCATEGORY_CLASS_HONOR_GRANT=3006;    // 动态类别-授予班级荣誉
    
    public static final int OPTCATEGORY_PERSON_DAILY_PUBLISH=100002;//个人发日志
    public static final int OPTCATEGORY_PERSON_PHOTO_UPLOAD_SINGALE=100008;//上传照片
    public static final int OPTCATEGORY_PERSON_ADD_FRIEND=100041;//加好友 
    public static final int OPTCATEGORY_PERSON_ASSIGN_HOMEWORK=100023;//布置作业
    public static final int OPTCATEGORY_PERSON_ASKING=100031;//提问
    public static final int OPTCATEGORY_PERSON_ANSWER =100032;//答疑
    public static final int OPTCATEGORY_PERSON_VIEW_DOC_RESOURCE=102011;//查看文档资源
    public static final int OPTCATEGORY_PERSON_VIEW_VIDEO_RESOURCE=102012;//查看视频资源
    
    public static final int OPTTYPE_ORIGINAL=1; // 动态操作类型-原创
    public static final int OPTTYPE_FORWARD=2; // 动态操作类型-转发
    public static final int OPTTYPE_SHARE=3; // 动态操作类型-分享

    //班级角色转换成客户端识别的代码
    public static Map<String,Object> classRole = new HashMap<String,Object>();
    static{
    	classRole.put("ROLE_CLASS_TEACHER", 1);
    	classRole.put("ROLE_CLASS_PARENT", 3);
    	classRole.put("ROLE_CLASS_STUDENT", 2);
    	classRole.put("ROLE_CLASS_MASTER", 1);
    	classRole.put("ROLE_UNKNOWN", 0);
    	classRole.put("ROLE_MULTI", 5);
    }

    public static String smstemplateValidcodeRegister="验证码为:${validcode},五分钟内有效";
    public static String smstemplateResetPassword="您的新密码为:${password}";
    public static String smstemplateResetChildPassword="您的小孩${childName}的新密码为:${password}";
    public static String smstemplateRegistChildPassword="您的小孩${childName}的密码为:${password}";


}
