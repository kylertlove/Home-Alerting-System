package net.kyler.alerting.util;

import lombok.Getter;

@Getter
public enum CarrierGateway {
    ATT("txt.att.net"), VERIZON("vtext.com"), TMobile("tmomail.net");

    private String gateway;

    CarrierGateway(String gateway) {
        this.gateway = gateway;
    }

}
