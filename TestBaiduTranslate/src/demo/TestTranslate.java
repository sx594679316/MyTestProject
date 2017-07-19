package demo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class TestTranslate {

	private static final String URL = "http://api.fanyi.baidu.com/api/trans/vip/translate";

	public static void main(String[] args) {
		String query = "猴子";
		get(query);
		post(query);
	}

	private static void get(String query) {
		CloseableHttpClient hc = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet();
		CloseableHttpResponse response;
		try {
			String q = URLEncoder.encode(query, "UTF-8");
			String from = "zh";
			String to = "en";
			String salt = RandomStringUtils.randomNumeric(8);
			// appid+q+salt+密钥
			String sign = "20160412000018425" + query + salt
					+ "UdOPt85bzYBT_21O1XSw";
			sign = getMd5(sign);
			System.out.println(sign);
			httpGet = new HttpGet(URL + "?q=" + q + "&from=" + from + "&to="
					+ to + "&appid=" + "20160412000018425" + "&salt=" + salt
					+ "&sign=" + sign);
			response = hc.execute(httpGet);
			System.out.println(EntityUtils.toString(response.getEntity()));
		} catch (UnsupportedEncodingException e) {
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void post(String query) {

		CloseableHttpClient hc = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(URL);

		CloseableHttpResponse response;
		try {
			String salt = RandomStringUtils.randomNumeric(8);
			// appid+q+salt+密钥
			String sign = getMd5("20160412000018425" + query + salt
					+ "UdOPt85bzYBT_21O1XSw");
			System.out.println(sign);
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("q", query));
			params.add(new BasicNameValuePair("from", "zh"));
			params.add(new BasicNameValuePair("to", "en"));
			params.add(new BasicNameValuePair("appid", "20160412000018425"));
			params.add(new BasicNameValuePair("salt", salt));
			params.add(new BasicNameValuePair("sign", sign));

			httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			response = hc.execute(httpPost);
			System.out.println(EntityUtils.toString(response.getEntity()));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpPost.releaseConnection();
		}
	}

	// 静态方法，便于作为工具类
	public static String getMd5(String plainText)
			throws UnsupportedEncodingException {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes("UTF-8"));// 中文一定要指定字符集
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位加密
			return buf.toString();
			// 16位的加密
			// return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}
}
