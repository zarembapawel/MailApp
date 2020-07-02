package com.zarembapawel.MailApp;

import com.zarembapawel.MailApp.attachment.Attachment;
import com.zarembapawel.MailApp.mailer.Mailer;
import com.zarembapawel.MailApp.message.Message;
import com.zarembapawel.MailApp.message.MessageDAO;
import com.zarembapawel.MailApp.recipient.Recipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mail")
public class MailController
{
    @Autowired
    private MessageDAO repository;

    @Autowired
    private Mailer mailer;

    @PostMapping("/add")
    public Message add(@RequestBody Message message)
    {
        //Assign recipients to message
        for(Recipient recipient : message.getRecipients())
        {
            recipient.setMessage(message);
        }

        //Assign attachments to message
        for(Attachment attachment : message.getAttachments())
        {
            attachment.setMessage(message);
        }

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
    public String sendAll()
    {
        int sendMessages = 0;

        List<Message> messages = repository.getUnsent();

        for(Message msg : messages)
        {
            //Sending e-mail
            mailer.send(msg);

            //Updating message sent status
            msg.setSent(true);

            repository.save(msg);

            sendMessages++;
        }

        return "Send e-mails: " + sendMessages;
    }
}
