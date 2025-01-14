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
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("gabriel7.gs61@gmail.com");
        mailSender.setPassword("aseievdfrthtgzcb");

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
        message.setSubject("Formulário recebido.");
        message.setText(
            budget.getName() + 
            ", sua solicitação de orçamento foi recebida com sucesso!" + 
            "\nEm breve entraremos em contato pelo whatsapp."
        );
        try {
            mailSender.send(message);
        } catch (MailException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public void notifySeller(Budget budget) {
        SimpleMailMessage message = new SimpleMailMessage(this.mailMessage);
        message.setTo("jauafelipe345@gmail.com");
        message.setSubject("Novo formulário salvo");
        message.setText("Informações para contato:"  + 
            "\nNOME: " + budget.getName() + 
            "\nEMPRESA: " + budget.getCompany() + 
            "\nTELEFONE: " + budget.getNumberPhone() + 
            "\nEMAIL: " + budget.getEmail());
        try {
            mailSender.send(message);
        } catch (MailException exception) {
            System.err.println(exception.getMessage());
        }
    }
}