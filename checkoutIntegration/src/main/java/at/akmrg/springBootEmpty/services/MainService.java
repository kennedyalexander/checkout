package at.akmrg.springBootEmpty.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import at.akmrg.springBootEmpty.model.Order;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;



/**
 * Created by alex on 4/21/17.
 */
@Service
public class MainService {

    MainService(){
        System.out.println("I have been created!");
    }

    public String test(){
        return "you asked for a new session";
    }

    public String createCheckoutSession(Order order, String orderCurrency) throws JSONException, IOException {
		String accessToken = "hJ5t5BBva8PxnEdcAvQl";
		String merchantNumber = "T072064101";
		String secretToken = "RGoCCNGCGHqDngGrpPKbYNgPzbnC1gfGCdg04RFG";
		String unencodedApiKey = accessToken + "@" + merchantNumber + ":" + secretToken;

		byte[] bytesEncoded = Base64.encodeBase64(unencodedApiKey.getBytes());

		byte[] unencodedApiKeyBytes = unencodedApiKey.getBytes();
		String encodedApiKey = new String(bytesEncoded);
		String checkoutEndpoint = "https://api.v1.checkout.bambora.com/sessions";

		HttpClient client = HttpClientBuilder.create().build();

		HttpPost post = new HttpPost(checkoutEndpoint);
		post.setHeader("Content-type", "application/json");
		post.setHeader("Authorization", "Basic " + encodedApiKey);
		post.setHeader("Accept", "application/json");

		JSONObject objOrder = new JSONObject();
		objOrder.put("id", order.getOrderID());
		objOrder.put("amount", order.getOrderValue());
		objOrder.put("currency", orderCurrency);

		JSONArray arrayCallback = new JSONArray();
		JSONObject objCallback = new JSONObject();
		objCallback.put("url", "https://example.org/callback");
		arrayCallback.put(objCallback);

		JSONObject objUrl = new JSONObject();
		objUrl.put("accept", "https://example.org/accept");
		objUrl.put("cancel", "https://example.org/cancel");
		objUrl.put("callback", arrayCallback);

		JSONObject objRequest = new JSONObject();
		objRequest.put("order", objOrder);
		objRequest.put("url", objUrl);

		StringEntity jsonRequest = new StringEntity(objRequest.toString(), "UTF-8");
		jsonRequest.setContentType("application/json");
		post.setEntity(jsonRequest);

		HttpResponse response = client.execute(post);

		if(response.getEntity().getContentLength() != 0) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			JSONObject responseJson = new org.json.JSONObject(result.toString());
			System.out.println(responseJson);

			return responseJson.getString("url");
		} else {
			return "No new session";
		}

//	  httpPost.setHeader("Content-type", "application/json");
//	  httpPost.setHeader("Authorization", "Basic " + encodedApiKey);
//	  httpPost.setHeader("Accept", "application/json");
//
//	org.apache.http.client.HttpClient client = org.apache.http.impl.client.
//			HttpClientBuilder.create().build();
//	org.apache.http.client.methods.HttpPost checkoutRequest =
//			new org.apache.http.client.methods.HttpPost(checkoutEndpoint);

//
//
//

//
//	org.apache.http.entity.StringEntity jsonRequest = new org.apache.http.
//			entity.StringEntity(objRequest.toString(), "UTF-8");
//  jsonRequest.setContentType("application/json");
//  checkoutRequest.setEntity(jsonRequest);
//
//	org.apache.http.HttpResponse checkoutResponse = client.execute(checkoutRequest);
//	java.io.BufferedReader rd = new java.io.BufferedReader(
//			new java.io.InputStreamReader(checkoutResponse.getEntity().getContent()));
//	StringBuffer result = new StringBuffer();
//	String line = "";
//  while ((line = rd.readLine()) != null) {
//		result.append(line);
//	}
//	org.json.JSONObject responseJson = new org.json.JSONObject(result.toString());
//	org.json.JSONObject meta = responseJson.getJSONObject("meta");


	}
}
