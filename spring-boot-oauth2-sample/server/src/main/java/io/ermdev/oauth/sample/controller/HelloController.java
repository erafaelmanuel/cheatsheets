package io.ermdev.oauth.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    @GetMapping("principal")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("hello")
    public String sayHello() {
        return "hello world";
    }

    @PostMapping("hello")
    public String sayHelloInSecret() {
        return "hello world";
    }
}
