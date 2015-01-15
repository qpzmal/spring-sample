package org.fightTiger.fighter.sample.common.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by LY on 14-3-27 上午11:37
 */
public class HttpClient {
	public static String post(String http, String content, String encode) {
		try {
			URL url = new URL(http);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(10000);
			con.setReadTimeout(20000);
			con.setRequestMethod("POST");
			con.setDoInput(true);
			con.setDoOutput(true);
			//con.setRequestProperty("Content-Type", "text/xml");
			OutputStream out = con.getOutputStream();
			out.write(content.getBytes(encode));
			out.flush();
			InputStream in = con.getInputStream();
			byte[] buf = new byte[1024];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while (true) {
				int readsize = in.read(buf);
				if (readsize == -1)break;
				baos.write(buf, 0, readsize);
			}
			in.close();
			return new String(baos.toByteArray(), encode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String syncpost(String http, String content, String encode) {
		try {
			URL url = new URL(http);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(10000);
			con.setReadTimeout(60 * 1000 * 2);
			con.setRequestMethod("POST");
			con.setDoInput(true);
			con.setDoOutput(true);
			OutputStream out = con.getOutputStream();
			out.write(content.getBytes(encode));
			out.flush();
			InputStream in = con.getInputStream();
			byte[] buf = new byte[1024];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while (true) {
				int readsize = in.read(buf);
				if (readsize == -1)break;
				baos.write(buf, 0, readsize);
			}
			in.close();
			return new String(baos.toByteArray(), encode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

    public static String get(String http, String content, String encode) {
        try {
            URL url = new URL(http);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(10000);
            con.setReadTimeout(20000);
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            //con.setRequestProperty("Content-Type", "text/xml");
            OutputStream out = con.getOutputStream();
            out.write(content.getBytes(encode));
            out.flush();
            InputStream in = con.getInputStream();
            byte[] buf = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (true) {
                int readsize = in.read(buf);
                if (readsize == -1)break;
                baos.write(buf, 0, readsize);
            }
            in.close();
            return new String(baos.toByteArray(), encode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String args[]) {

        System.out.println(post("http://112.33.2.95:8882/educloudapi/crossapi/vpaas/video_get_publish_info","video_refer_id=851972","utf-8"));

    }
}
