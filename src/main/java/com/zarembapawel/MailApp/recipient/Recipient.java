package com.zarembapawel.MailApp.recipient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zarembapawel.MailApp.message.Message;

import javax.persistence.*;

@Entity
@Table(name = "recipients")
public class Recipient
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

    @Column(name = "email")
    private String email;

    public Recipient()
    {
    }

    public Recipient(String email)
    {
        this.email = email;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
