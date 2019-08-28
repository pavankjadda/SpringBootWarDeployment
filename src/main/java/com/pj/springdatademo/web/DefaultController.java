package com.pj.springdatademo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class DefaultController
{

    @GetMapping(path = "/error")
    public String getPosts()
    {
        return "Error occurred";
    }


    @GetMapping(path = "/")
    public String deleteAndGetPosts()
    {
        return "Welcome Home";
    }
}

