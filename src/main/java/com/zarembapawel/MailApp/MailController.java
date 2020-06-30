package com.zarembapawel.MailApp;

import com.zarembapawel.MailApp.message.Message;
import com.zarembapawel.MailApp.message.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mail")
public class MailController
{
    @Autowired
    private MessageDAO repository;

    @GetMapping("/list")
    public List<Message> list()
    {
        return repository.getAll();
    }

    @GetMapping("/get/{id}")
    public Message get(@PathVariable int id)
    {
        return repository.get(id);
    }
}
