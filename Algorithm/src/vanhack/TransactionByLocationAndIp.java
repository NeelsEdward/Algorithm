package vanhack;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.event.AncestorEvent;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TransactionByLocationAndIp {

	static String uri = "https://jsonmock.hackerrank.com/api/transactions/search?userId=2";

	public static void main(String[] args) throws Exception {

		JsonObject jsonObject = new JsonObject();
		String httpsURL = "https://jsonmock.hackerrank.com/api/transactions/search?userId=2&page=8";
		System.out.println(getAmount(1, 9, 100, 220));
	}

	public static JsonObject getJsonResponse(String url) {

		URL myUrl;
		JsonObject jsonObject = null;
		try {
			myUrl = new URL(url);
			HttpsURLConnection conn = (HttpsURLConnection) myUrl.openConnection();
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String input;
			JsonElement jsonElement = null;
			while ((input = br.readLine()) != null) {
				jsonElement = new JsonParser().parse(input);
			}
			jsonObject = jsonElement.getAsJsonObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	public static float getAmount(JsonObject jsonObject, int userId, int locationId, int netStart, int netEnd) {

		float answer = 0;
		JsonArray data = jsonObject.getAsJsonArray("data");
		for (int i = 0; i < data.size(); i++) {
			JsonObject json = data.get(i).getAsJsonObject();
			int uId = json.get("userId").getAsInt();
			String ipString = json.get("ip").getAsString();
			StringBuilder ipBuilder = new StringBuilder();
			for (int s = 0; s < ipString.indexOf('.'); s++) {
				ipBuilder.append(ipString.charAt(s));
			}
			int ip = 0;
			if (ipBuilder.length() > 0) {
				ip = Integer.parseInt(ipBuilder.toString());
			}
			JsonObject locationJsonObject = json.get("location").getAsJsonObject();
			int lId = locationJsonObject.get("id").getAsInt();
			StringBuilder builder = new StringBuilder();
			if (uId == userId && ip >= netStart && ip <= netEnd && lId == locationId) {
				String amount = json.get("amount").getAsString();
				for (int a = 1; a < amount.length(); a++) {
					char c = amount.charAt(a);
					if (c != ',') {
						builder.append(c);
					}
				}
			}
			if (builder.length() > 0) {
				int decimalIndex =builder.indexOf(".");
				if(decimalIndex > 0){
					String s = "";
					for(int b=0;b<decimalIndex;b++){
						s +=builder.charAt(b);
					}
					answer += Float.parseFloat(s);
					String afterDecimal = builder.substring((decimalIndex+1), builder.length());
					answer +=(Float.parseFloat(afterDecimal)/100);
					
				}else{
					answer += Float.parseFloat(builder.toString());
				}
			}
		}

		return answer;
	}

	public static int getAmount(int userId, int locationId, int netStart, int netEnd) {

		String initialUrl = "https://jsonmock.hackerrank.com/api/transactions/search?userId=" + userId;
		String pageUrl = "&page=";
		JsonObject jsonObject = getJsonResponse(initialUrl);
		int page = jsonObject.get("page").getAsInt();
		int total_pages = jsonObject.get("total_pages").getAsInt();
		float amount = getAmount(jsonObject, userId, locationId, netStart, netEnd);
		page++;
		while (page <= total_pages) {
			String paginationUrl = initialUrl + pageUrl + page;
			amount += getAmount(getJsonResponse(paginationUrl), userId, locationId, netStart, netEnd);
			page++;
		}

		return Math.round(amount);
	}

}
