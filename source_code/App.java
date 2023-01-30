package com.chucknorris.chuckNorris;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class App 
{
    public static void main( String[] args )
    {
    	try {
    		chuckNorris();
    	}catch (URISyntaxException e) {
    		System.out.print("No");
    	}catch (IOException e) {
    		System.out.print("No");
    	}
    }
    
    public static void chuckNorris() throws URISyntaxException, IOException {
    	
    	URIBuilder builder = new URIBuilder("https://api.chucknorris.io/jokes/random");
    	//build object 
    	HttpGet getData = new HttpGet(builder.build());
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	CloseableHttpResponse respone = httpClient.execute(getData);
    	HttpEntity responseEntity = respone.getEntity();
    	String result = EntityUtils.toString(responseEntity);
    	System.out.println("JSON data :");
    	System.out.println(result);
    	JSONObject responseObj = new JSONObject(result);
    	
    	String value = responseObj.getString("value");
    	String create = responseObj.getString("created_at");
    	String id = responseObj.getString("id");
    	String url = responseObj.getString("url");
    	String icon_url = responseObj.getString("icon_url");
    	
    	System.out.println("ID: "+id);
    	System.out.println("create: "+create);
    	System.out.println("url: "+url);
    	System.out.println("Icon: "+icon_url);
    	System.out.println("Jokes: "+value);

    	httpClient.close();
    }
}

