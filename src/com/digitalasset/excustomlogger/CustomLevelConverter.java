package com.digitalasset.excustomlogger;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class CustomLevelConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        String message = event.getFormattedMessage();
        if (message.contains("ERROR")) {
            return "ERROR";
        } else if (message.contains("WARN")) {
            return "WARN";
        } else {
            return event.getLevel().toString();
        }
    }
}