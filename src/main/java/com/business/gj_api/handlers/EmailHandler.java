package com.business.gj_api.handlers;

import java.util.Properties;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.business.gj_api.models.Budget;

public class EmailHandler {
    
    private JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.example.com");
        mailSender.setPort(587);
        mailSender.setUsername("gabriel");
        mailSender.setPassword("gabriel");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
    private MailSender mailSender = javaMailSender();

    
    private SimpleMailMessage templateMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("gabriel7.gs61@example.com");
        return message;
    }
    private SimpleMailMessage mailMessage = templateMessage();

    public void sendEmailToNewBudget(Budget budget) {
        SimpleMailMessage message = new SimpleMailMessage(this.mailMessage);
        message.setTo(budget.getEmail());
        message.setText(
            "Caro " + budget.getName() + ", sua solicitação de orçamento foi recebida com sucesso!" + "/nEm breve entraremos em contato pelo whatsapp"
        );
        try {
            mailSender.send(message);
        } catch (MailException exception) {
            System.err.println(exception.getMessage());
        }
    }
}