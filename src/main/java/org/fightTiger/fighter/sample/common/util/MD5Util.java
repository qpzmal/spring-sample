package org.fightTiger.fighter.sample.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// import org.apache.commons.codec.digest.Md5Crypt;

/**
 * Created by LY on 2014/11/27.
 */
public class MD5Util {

    private static final String salt="njxtqgjyptfromlianchuang";

    private static String salt(String password) {
        return password + salt;
    }

    /**
     * md5+Base64组合算法
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static  String md5Base64(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String result = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return result;
    }

    /**
     * md5+Base64+Salt 算法
     * @param password
     * @return
     */
    public static String md5Base64Salt(String password) {
        String result = null;
        try {
            result = md5Base64(salt(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String args[]) throws  Exception{
       System.out.println(MD5Util.md5Base64Salt("111qqqaaa"));

        String jj="111222qqq";
//        String kk=Md5Crypt.md5Crypt(salt(jj).getBytes("utf-8"));
//        System.out.println( kk);
        BASE64Encoder base64en = new BASE64Encoder();
//        System.out.println(base64en.encode(kk.getBytes()));

        String aaa=DigestUtils.md5(salt(jj).getBytes("utf-8")).toString();
        System.out.println(aaa);
        String bbb=base64en.encode(aaa.getBytes("utf-8"));
        System.out.println(bbb);
        System.out.println(base64en.encode(DigestUtils.md5(salt(jj).getBytes("utf-8"))));

        String aaaa=DigestUtils.md5Hex(salt(jj).getBytes("utf-8"));
        System.out.println(aaaa);
        System.out.println(base64en.encode(aaaa.getBytes()));
        BASE64Decoder base64Decoder=new BASE64Decoder();
        System.out.println(base64Decoder.decodeBuffer("GZ/JbTSt87atIcpUiKbqQg=="));
    }
}
