package org.example.mail.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.mail.dto.NotificationDto;
import org.example.mail.service.MailSender;
import org.example.mail.service.MailService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final MailSender mailSender;

    @Override
    public void send(NotificationDto notificationDto) {
        mailSender.sendEmail(notificationDto.getUserMail(), notificationDto.getType(), notificationDto.getText());
    }

}
