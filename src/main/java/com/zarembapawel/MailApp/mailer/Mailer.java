package com.zarembapawel.MailApp.mailer;

import com.zarembapawel.MailApp.attachment.Attachment;
import com.zarembapawel.MailApp.message.Message;
import com.zarembapawel.MailApp.recipient.Recipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
public class Mailer
{
    private JavaMailSender javaMailSender;
    private MailContentBuilder mailContentBuilder;

    @Autowired
    public Mailer(JavaMailSender javaMailSender, MailContentBuilder mailContentBuilder)
    {
        this.javaMailSender = javaMailSender;
        this.mailContentBuilder = mailContentBuilder;
    }

    public void send(Message message)
    {
        if(true)
        {
            MimeMessagePreparator messagePreparator = mimeMessage ->
            {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
                messageHelper.setFrom(message.getSender());
                messageHelper.setSubject(message.getTopic());
                messageHelper.setPriority(message.getPriority());
                String content = mailContentBuilder.build(message.getContent());
                messageHelper.setText(content, true);

                for(Recipient recipient : message.getRecipients())
                {
                    messageHelper.setTo(recipient.getEmail());
                }

                for(Attachment attachment : message.getAttachments())
                {
                    messageHelper.addAttachment(attachment.getName(), new File(attachment.getUrl()));
                }
            };

            try
            {
                javaMailSender.send(messagePreparator);
            }

            catch (MailException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
