package com.zarembapawel.MailApp;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "messages")
public class Message
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "topic")
    private String topic;

    @Column(name = "content")
    private String content;

    @Column(name = "sender")
    private String sender;

    @Column(name = "recipients")
    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
    private List<Recipient> recipients;

    @Column(name = "sent")
    private Boolean sent;


    public Message()
    {
        this.sent = false;
    }

    public Message(String topic, String content, String sender, List<Recipient> recipients)
    {
        super();

        this.topic = topic;
        this.content = content;
        this.sender = sender;
        this.recipients = recipients;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTopic()
    {
        return topic;
    }

    public void setTopic(String topic)
    {
        this.topic = topic;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getSender()
    {
        return sender;
    }

    public void setSender(String sender)
    {
        this.sender = sender;
    }

    public List<Recipient> getRecipients()
    {
        return recipients;
    }

    public void setRecipients(List<Recipient> recipients)
    {
        this.recipients = recipients;
    }

    public Boolean getSent()
    {
        return sent;
    }

    public void setSent(Boolean sent)
    {
        this.sent = sent;
    }
}
