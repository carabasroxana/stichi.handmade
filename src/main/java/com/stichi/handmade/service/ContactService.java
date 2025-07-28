package com.stichi.handmade.service;

import com.stichi.handmade.model.ContactForm;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final JavaMailSender mailSender;

    public ContactService (JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(ContactForm form) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("stichi.handmade@gmail.com");
        mail.setSubject("New contact from " + form.getName());
        mail.setText(
                "Name: " + form.getName() + "\n" +
                        "Email: " + form.getEmail() + "\n\n" +
                        form.getMessage()
        );
        mailSender.send(mail);
    }
}
