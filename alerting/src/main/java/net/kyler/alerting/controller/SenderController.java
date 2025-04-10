package net.kyler.alerting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.kyler.alerting.model.Message;
import net.kyler.alerting.service.AlertingService;

@RestController
@AllArgsConstructor
public class SenderController {

    private final AlertingService alertingService;

    @PostMapping("/send-sms")
    @ResponseStatus(HttpStatus.OK)
    public void sendSms(@RequestBody Message message) {
        alertingService.sendTextMessage(message);
    }
    
}
