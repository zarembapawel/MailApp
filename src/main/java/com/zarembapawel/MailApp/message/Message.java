package com.zarembapawel.MailApp.message;

import com.zarembapawel.MailApp.attachment.Attachment;
import com.zarembapawel.MailApp.recipient.Recipient;

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

    @Column(name = "attachments")
    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
    private List<Attachment> attachments;

    @Column(name = "priority")
    private int priority;

    @Column(name = "sent")
    private Boolean sent;


    public Message()
    {
        this.sent = false;
    }

    public Message(String topic, String content, String sender, List<Recipient> recipients, List<Attachment> attachments, int priority)
    {
        this();

        this.topic = topic;
        this.content = content;
        this.sender = sender;
        this.recipients = recipients;
        this.attachments = attachments;
        this.priority = priority;
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

    public List<Attachment> getAttachments()
    {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments)
    {
        this.attachments = attachments;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
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
