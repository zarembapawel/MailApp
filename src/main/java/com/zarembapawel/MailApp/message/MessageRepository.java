package com.zarembapawel.MailApp.message;

import com.zarembapawel.MailApp.Message;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MessageRepository implements MessageDAO
{
    @Autowired
    private EntityManager em;

    @Override
    public List<Message> getAll()
    {
        Session s = em.unwrap(Session.class);

        Query<Message> messages = s.createQuery("from Message", Message.class);

        return messages.getResultList();
    }

    @Override
    public Message get(int id)
    {
        Session s = em.unwrap(Session.class);

        return s.get(Message.class, id);
    }

    @Override
    public void add(Message message)
    {
        Session s = em.unwrap(Session.class);

        s.saveOrUpdate(message);
    }

    @Override
    public void delete(int id)
    {
        Session s = em.unwrap(Session.class);

        Query q = s.createQuery("delete from Message where id = :id");

        q.setParameter("id", id);

        q.executeUpdate();
    }
}
