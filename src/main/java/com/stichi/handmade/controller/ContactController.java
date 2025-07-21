package com.stichi.handmade.controller;

import com.stichi.handmade.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact/form";
    }

    @PostMapping
    public String submitContactForm(
            @ModelAttribute("contactForm") @Valid ContactForm form,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "contact/form";
        }

        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo("stichi.handmade@example.com"); // ← replace with your “To:” address
            mail.setSubject("New contact from " + form.getName());
            mail.setText(
                    "Name: " + form.getName() + "\n" +
                            "Email: " + form.getEmail() + "\n\n" +
                            "Message:\n" + form.getMessage()
            );
            mailSender.send(mail);

            model.addAttribute("successMessage", "contact.success");
        } catch (Exception ex) {
            model.addAttribute("errorMessage", "contact.error");
        }

        return "contact/form";
    }
}
