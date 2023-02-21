package com.spring101.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("Hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!" );
        return "hello";
    }
    @GetMapping("hell-mvc")
    public String helloMvc(@RequestParam(value="name", required =true) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    //데이터 줄때
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name) {
            this.name=name;
        }
    }
}
