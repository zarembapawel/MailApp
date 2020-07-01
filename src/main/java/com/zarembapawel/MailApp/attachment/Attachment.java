package com.zarembapawel.MailApp.attachment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zarembapawel.MailApp.message.Message;

import javax.persistence.*;

@Entity
@Table(name = "attachments")
public class Attachment
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "message")
    @JsonIgnore
    private Message message;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    public Attachment()
    {
    }

    public Attachment(String name, String url)
    {
        this.name = name;
        this.url = url;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Message getMessage()
    {
        return message;
    }

    public void setMessage(Message message)
    {
        this.message = message;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
