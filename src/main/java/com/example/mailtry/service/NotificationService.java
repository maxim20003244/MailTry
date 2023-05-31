package com.example.mailtry.service;



import com.example.mailtry.model.User;
import org.springframework.mail.MailException;


public interface NotificationService {
    public void sendNotification (User user) throws MailException;
}
