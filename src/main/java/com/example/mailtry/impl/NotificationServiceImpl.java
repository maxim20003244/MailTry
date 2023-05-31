package com.example.mailtry.impl;



import com.example.mailtry.model.User;
import com.example.mailtry.service.NotificationService;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
  private final JavaMailSender javaMailSender;

    public NotificationServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void  sendNotification(User user) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("maximum.rot@gmai.com");
        mail.setSubject("Test subject");
        mail.setText("Hi "+ user.getName()+" Sending from spring");
        javaMailSender.send(mail);
    }


}
