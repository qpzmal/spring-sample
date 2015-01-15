package org.fightTiger.fighter.sample.common.util;

import java.io.IOException;
import java.util.Properties;

public class AppPropertiesUtil {
	    private static Properties p = new Properties();  
	    static{  
	        try {  
	            p.load(AppPropertiesUtil.class.getClassLoader().getResourceAsStream("META-INF/app.properties"));  
	        } catch (IOException e) {  
	            e.printStackTrace();   
	        }  
	    }  
	    
	    public static String getValue(String key){  
	        return p.getProperty(key);  
	    }  
	    public static void main(String[] args) {
			System.out.println("---------------------------------------"+getValue("weibo.dbpath"));
		}
}
