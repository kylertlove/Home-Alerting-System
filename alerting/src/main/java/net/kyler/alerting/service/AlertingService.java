package net.kyler.alerting.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.kyler.alerting.model.Message;

@AllArgsConstructor
@Service
@Slf4j
public class AlertingService {
    
    private final JavaMailSender mailSender;

    public void sendTextMessage(Message message) {
        String to;
        if(message.getGateway() != null) {
            to = message.getUserIdentifier() + "@" + message.getGateway().getGateway();
        } else {
            to = message.getUserIdentifier();
        }
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setFrom("HomeAlertingMessage@Kyler.com");
        mailMessage.setSubject(message.getHeader());
        mailMessage.setText(message.getMessage());
        log.info("Sending Alert: {}", mailMessage.toString());
        mailSender.send(mailMessage);
    }
}
