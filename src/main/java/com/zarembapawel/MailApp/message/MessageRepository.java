package com.zarembapawel.MailApp.message;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
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

        Message message = s.get(Message.class, id);

        return message;
    }

    @Override
    @Transactional
    public void save(Message message)
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

    @Override
    public List<Message> getUnsent()
    {
        Session s = em.unwrap(Session.class);

        Query<Message> messages = s.createQuery("from Message where sent != 1", Message.class);

        return messages.getResultList();
    }
}
