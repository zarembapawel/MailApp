package com.zarembapawel.MailApp.message;

import com.zarembapawel.MailApp.Message;

import java.util.List;

public interface MessageDAO
{
    public List<Message> getAll();

    public Message get(int id);

    public void add(Message message);

    public void delete(int id);
}
