package com.usco.project.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

import java.io.File;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

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

    @Value("${serverinfo.url}")
    String url;

    public void sendActivationEmail(String from, String to, String subject, String link) throws IOException {
        String htmlMsg = "<h3>Bienvenido a Buscapp</h3>" + "<p>Para activar tu cuenta da click <a href=\"" + url + link
                + "\">aqui</a></p>" + "<br>"
                + "<p style=\"font-style: oblique\">Si crees que es un error has caso omiso a este mensaje</p>";
        /* Email emailFrom = new Email(from);
        String emailSubject = subject;
        Email emailTo = new Email(to);
        Content emailContent = new Content("text/html", htmlMsg);
        Mail mail = new Mail(emailFrom, emailSubject, emailTo, emailContent);
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));

        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println("status "+response.getStatusCode());
            System.out.println("body "+response.getBody());
            System.out.println("headers "+response.getHeaders());

        } catch (IOException e) {
            System.out.println(e);
        } */

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

    public ClientResponse sendComplexMessage(String to, String link) {
        String htmlMsg = "<h3>Bienvenido a Buscapp</h3>" + "<p>Para activar tu cuenta da click <a href=\"" + url + link
        + "\">aqui</a></p>" + "<br>"
        + "<p style=\"font-style: oblique\">Si crees que es un error has caso omiso a este mensaje</p>";
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("api", System.getenv("MAILGUN_API_KEY")));
        WebResource webResource = client.resource("https://api.mailgun.net/v3/" + System.getenv("MAILGUN_DOMAIN")
            + "/messages");
        FormDataMultiPart formData = new FormDataMultiPart();
        formData.field("from", "<mailgun@" + System.getenv("MAILGUN_DOMAIN") + ">");
        formData.field("to", to);
        formData.field("subject", "Activacion de cuenta");
        formData.field("html", htmlMsg);
        return webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE)
            .post(ClientResponse.class, formData);
      }
}