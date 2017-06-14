import com.google.gson.Gson;
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
import java.util.ArrayList;

/*
 * Created by corinne on 6/13/17.
 */
public class Client{
    String url;  //"http://localhost:8000/messages";
    final HttpClient client = HttpClientBuilder.create().build();
    final Gson gson = new Gson();

    public Client(String url){
        this.url = url;

    }

    public ArrayList<Message> getRequest(String user) {
        HttpGet get = new HttpGet(url);
        get.setHeader("Content-type", "application/json");
        get.setHeader("user",user );
        ArrayList<Message> list = new ArrayList<>();
        try {
            HttpResponse response = client.execute(get);
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            while (br.ready()) {
                list.add(gson.fromJson(br, Message.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }

    public void postRequest(Message message) {
        String jSon = gson.toJson(message);
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-type", "application/json");
        post.setHeader("user", message.sender);

        try {
            StringEntity input = new StringEntity(jSon);
            input.setContentType("application/json");
            post.setEntity(input);
            client.execute(post);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
