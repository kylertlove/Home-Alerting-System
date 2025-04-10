package net.kyler.alerting.model;

import lombok.Data;
import net.kyler.alerting.util.CarrierGateway;

@Data
public class Message {
    private String phoneNumber;
    private String header;
    private String message;
    private CarrierGateway gateway;

}
