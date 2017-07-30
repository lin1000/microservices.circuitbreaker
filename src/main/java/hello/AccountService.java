package hello;

import java.net.URI;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class AccountService extends HystrixCommand<String> {

    private OkHttpClient client = new OkHttpClient();
    public static final String url = "http://127.0.0.1:3000/";
    private final String name;

    public AccountService(String name) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("AccountService"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withFallbackEnabled(false))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter() .withCircuitBreakerEnabled(true))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(3500))
            );

            this.name = name;
    }

    @Override
    protected String run() {
     return getAccountInfo(this.url);
    }

    String getAccountInfo(String url) {
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        return "Something went wrong";
  }

    @Override
    protected String getFallback() {
        return "Your Account Name is extremely import for us to serve you better, we encourage you login here.";
    }

}