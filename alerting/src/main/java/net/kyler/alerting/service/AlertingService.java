package net.kyler.alerting.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.kyler.alerting.model.Message;

@AllArgsConstructor
@Service
public class AlertingService {
    
    private final JavaMailSender mailSender;

    public void sendTextMessage(Message message) {
        String to = message.getPhoneNumber() + "@" + message.getGateway().getGateway();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(message.getHeader());
        mailMessage.setText(message.getMessage());
        mailSender.send(mailMessage);
    }
}
