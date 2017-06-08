/**
 * Created by ros_crherzog on 6/8/2017.
 */
import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Client {
    public static void main(String[] args){
        DefaultHttpClient client = new DefaultHttpClient();
        HttpHost target = new HttpHost("weather.yahooapis.com", 80, "http");


    }
}

