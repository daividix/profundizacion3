package com.usco.project.service;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.beans.factory.annotation.Value;

@Service("email_service")
public class EmailService {

    private JavaMailSender mailSender;
 
    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Value("${serverinfo.url}") String url;
 
    public void sendActivationEmail(String from, String to, String subject, String link) {
        String htmlMsg = "<h3>Bienvenido a Buscapp</h3>" + "<p>Para activar tu cuenta da click <a href=\"" + url+link
                + "\">aqui</a></p>" + "<br>"
                + "<p style=\"font-style: oblique\">Si crees que es un error has caso omiso a este mensaje</p>";
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(htmlMsg, true);
        };
        try {
            mailSender.send(messagePreparator);
        } catch (MailException e) {
            System.out.println(e);
        }
    }

}