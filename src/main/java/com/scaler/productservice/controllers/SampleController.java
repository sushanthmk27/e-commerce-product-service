package com.scaler.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    //<domain-name>/sample/helloworld
    @GetMapping("/helloworld")
    public String sample(){
        return "Hello World";
    }

    //<domain-name>/sample/helloworld2
    @GetMapping("/helloworld2")
    public String sample2(){
        return "Hello World2";
    }
}
