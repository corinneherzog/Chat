import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by corinne on 6/13/17.
 */
public class Client {
    public static String url;
    public static HttpClient client = HttpClientBuilder.create().build();
    public static void main(String[] args){
        if(args.length > 0){
            url = args[0];
        }
        else{
            url = "http://localhost:8000/messages";
        }

    }

    public static ArrayList<Message> getRequest(Gson gson , String user) {
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
}
