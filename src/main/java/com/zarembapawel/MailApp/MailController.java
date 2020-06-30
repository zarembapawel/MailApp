package com.zarembapawel.MailApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController
{
    @GetMapping("/list")
    public String list()
    {
        return "Test";
    }
}
