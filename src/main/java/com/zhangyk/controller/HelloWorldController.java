package com.zhangyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yunkai on 7/8/17.
 */
@Controller
public class HelloWorldController {

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String healthCheck() {
        return "hello";
    }
}
