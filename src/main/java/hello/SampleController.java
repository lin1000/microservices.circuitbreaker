package hello;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;


@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        AccountService accountService = new AccountService("MyAccountService");
        String apiResponse = accountService.execute();
        StringBuffer myResponse = new StringBuffer("Calling to External API Services "+AccountService.url+" <br/><hr/>");
        myResponse.append(apiResponse);
        myResponse.append("<hr/>");
        return myResponse.toString();
    }    
    
 public static void main(String[] args) throws Exception {
       SpringApplication.run(SampleController.class, args);
  }
}