package com.zarembapawel.MailApp;

import com.zarembapawel.MailApp.message.Message;
import com.zarembapawel.MailApp.message.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mail")
public class MailController
{
    @Autowired
    private MessageDAO repository;

    @PostMapping("/add")
    public Message add(@RequestBody Message message)
    {
        repository.save(message);

        return message;
    }

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

    @GetMapping("/status/{id}")
    public String status(@PathVariable int id)
    {
        Message message = repository.get(id);

        if(message == null) return null;

        return (message.getSent()) ? "sent" : "pending";
    }

    @PutMapping("/sendAll")
    public int sendAll()
    {
        int sendMessages = 0;

        List<Message> messages = repository.getUnsent();

        for(Message msg : messages)
        {
            //@TODO send email

            msg.setSent(true);

            repository.save(msg);

            sendMessages++;
        }

        return sendMessages;
    }
}
