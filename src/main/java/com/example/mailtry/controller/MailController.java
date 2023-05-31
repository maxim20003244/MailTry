package com.example.mailtry.controller;

import com.example.mailtry.model.User;
import com.example.mailtry.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
private static Logger log = LoggerFactory.getLogger(MailController.class);

@GetMapping("/send")
  public String sendMail(){
      User user = new User();
      user.setName("Maxim");
      user.setEmail("maxim20003244@gmail.com");
try {
    notificationService.sendNotification(user);
    return "Mail has been send";
} catch (MailException e){
    log.error("Could not send email to: " + user.getName(), e);
}
return "Oops something bad";
  }
    @Autowired
    public NotificationService notificationService;


}
