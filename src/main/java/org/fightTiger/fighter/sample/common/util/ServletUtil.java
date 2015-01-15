package org.fightTiger.fighter.sample.common.util;

import javax.servlet.http.HttpServletRequest;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * servlet的基本操作
 * User: THINKPAD
 * Date: 2009-7-17
 * Time: 9:11:08
 */
public class ServletUtil {
	public static String serverIp=getLocalAddress();
	/**
	 * 获得当前完整的url路径，包括了url后的参数串
	 * @param request
	 * @return 返回url + 完整的参数串
	 */
	@SuppressWarnings("unchecked")
	public static  String buildOriginalURL(HttpServletRequest request) {
        StringBuffer originalURL = request.getRequestURL();
        Map parameters = request.getParameterMap();
        if (parameters != null && parameters.size() > 0) {
            originalURL.append("?");
            for (Iterator iter = parameters.keySet().iterator(); iter.hasNext();) {
                String key = (String) iter.next();
                String[] values = (String[]) parameters.get(key);
                for (int i = 0; i < values.length; i++) {
                    originalURL.append(key).append("=").append(values[i]).append("&");
                }
            }
        }
        return originalURL.toString();
    }
	/**
	 * 返回本地服务器ip地址
	 * @return serverIp
	 */
	public static String getLocalAddress() {
        try {
            Map<String, String> nameAddress = new HashMap<String, String>();
            Enumeration<NetworkInterface> interfaces=  NetworkInterface.getNetworkInterfaces();
            while(interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                while(addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if(addr.isLoopbackAddress()) continue;
                    if(addr.getHostAddress().indexOf(":") != -1) continue;
                    if("bond0".equals(ni.getName())) return addr.getHostAddress();
                    nameAddress.put(ni.getName(), addr.getHostAddress());
                }
            }
            return nameAddress.size() > 0 ?
                    nameAddress.values().iterator().next() : "0.0.0.0";

        }catch(Exception e) {
            return "0.0.0.0";
        }
    }
	/**
	 * 返回请求客户端ip地址
	 * @param request
	 * @return userIp
	 */
	public static String getUserIpAddr(HttpServletRequest request) {        
	     String ip = request.getHeader("x-forwarded-for");        
	     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
	         ip = request.getHeader("Proxy-Client-IP");        
	     }        
	     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {        
	    	 ip = request.getHeader("WL-Proxy-Client-IP");        
	     }        
	     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {        
	    	 ip = request.getRemoteAddr();        
	     }        
	     return ip;  
	}
}