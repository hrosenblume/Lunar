package com.example.android.animationsdemo;
import com.loopj.android.http.*;

public class LunaRestClient {
	private static final String BASE_URL = "http://vast-sea-6978.herokuapp.com/";

	  private static AsyncHttpClient client = new AsyncHttpClient();
     // 
	  public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		  client.setBasicAuth("atlanta","atlanta");
	      client.get(getAbsoluteUrl(url), params, responseHandler);
	  }

	  public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
	      client.post(getAbsoluteUrl(url), params, responseHandler);
	  }

	  private static String getAbsoluteUrl(String relativeUrl) {
	      return BASE_URL + relativeUrl;
	  }

}
