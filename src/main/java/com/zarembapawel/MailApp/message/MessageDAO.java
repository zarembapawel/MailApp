package com.zarembapawel.MailApp.message;

import java.util.List;

public interface MessageDAO
{
    public List<Message> getAll();

    public Message get(int id);

    public void save(Message message);

    public void delete(int id);

    public List<Message> getUnsent();
}
