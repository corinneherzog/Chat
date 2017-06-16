//import files to make it work
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by corinne on 6/13/17.
 */

public class Client {
    //fields
    String url;
    final HttpClient httpClient = HttpClientBuilder.create().build();
    final Gson gson = new Gson();

    //Input the ui and construces it
    public Client(String url){
        this.url = url;

    }
    
    //input user creates chat and output empty message arraylist
    public ArrayList<Message> getRequest(String user) {
        final HttpClient httpClient = HttpClientBuilder.create().build();
        String url = "http://localhost:8000/messages";
        final Gson gson = new Gson();
        HttpGet get = new HttpGet(url);
        get.setHeader("accept", "application/json");
        get.setHeader("user", user);
        Type collectionType = new TypeToken<ArrayList<Message>>() {
        }.getType();


        try {
            HttpResponse response = httpClient.execute(get);
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String jSon = br.readLine();
            return gson.fromJson(jSon, collectionType);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<Message>();
    }

    //sends new information the the server
    public void postRequest(Message message) {
        String jSon = gson.toJson(message);
        HttpPost post = new HttpPost(url);
        post.setHeader("accept", "application/json");
        post.setHeader("user", message.sender);

        try {
            StringEntity input = new StringEntity(jSon);
            input.setContentType("application/json");
            post.setEntity(input);
            httpClient.execute(post);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
