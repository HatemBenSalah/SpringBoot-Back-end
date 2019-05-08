package com.template.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class NotificationTokenService {
	//default API url
	private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send"; 
	//console firebase -> project -> projet settings -> cloud messaging tab -> Server key
	private static final String FIREBASE_SERVER_KEY = "AAAAfr-sDdo:APA91bHWhgbc071FGhvnpXkXQUoP92TxnfGULrDLynnWBaK1pKbY7nNmhMDfCQSEq7iZQYHNmn__oEuWZfC58Uw-cWv-8FZWR7CrBhDwe3W7igzFmqRBNHy_XAuOUQzgNwkYmAUcBWmA";

	public String sendPushNotification(String string, String Message, String Message1) throws IOException {

		String result = "";
		URL url = new URL(FIREBASE_API_URL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "key=" + FIREBASE_SERVER_KEY);
		conn.setRequestProperty("Content-Type", "application/json");

		JSONObject json = new JSONObject();

		try {
			
				json.put("to", string.trim());
				JSONObject info = new JSONObject();
				info.put("title", Message); // Notification title
				info.put("body", Message1); // Notification
				json.put("data", info);
				JSONObject ttl = new JSONObject();
				ttl.put("TTL", 86400);
				JSONObject header = new JSONObject();
				header.put("headers", ttl);
				json.put("webpush", header);
				
		} catch (JSONException e1) {
			e1.printStackTrace();
		}

		try {
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(json.toString());
			wr.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output.contains("\"failure\":1"));
				System.out.println(output);
				
			}
		
			result = "succcess";
		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		}
		System.out.println("GCM Notification is sent successfully");

		return result;

	}
}
