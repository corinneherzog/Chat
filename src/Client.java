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

    //Given a url constructs a client with this url
    public Client(String url){
        this.url = url;

    }
    
    //Given a user performs a get request for this user's messages
    // returns an arraylist of that user's messages
    public ArrayList<Message> getRequest(String user) {
        final HttpClient httpClient = HttpClientBuilder.create().build();
        String url = "http://localhost:8000/messages";
        final Gson gson = new Gson();
        HttpGet get = new HttpGet(url);
        get.setHeader("accept", "application/json");
        get.setHeader("user", user);
        // first need to create a new object that is an arraylist of messages
        Type collectionType = new TypeToken<ArrayList<Message>>() {
        }.getType();


        try {
            // then all of the users messages can be converted from jSon straight into that arraylist of messages
            HttpResponse response = httpClient.execute(get);
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String jSon = br.readLine();
            return gson.fromJson(jSon, collectionType);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<Message>();
    }

    //converts a given message to jSon and posts to server
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
