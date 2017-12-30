package com.practise.springboot.hello;

import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pratik Ambani on 24/12/16.
 * <p>
 * Controller class, maps to URL
 */

@RestController
public class HelloWorldController {


    @ApiOperation(value = "Sample Hello World Application", notes = "01. Prints sample text with this URL")
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }


}
