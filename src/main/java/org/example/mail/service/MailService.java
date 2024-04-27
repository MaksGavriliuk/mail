package org.example.mail.service;

import org.example.mail.dto.NotificationDto;

public interface MailService {
    void send(NotificationDto notificationDto);
}
