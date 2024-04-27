package org.example.mail.consumer.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.mail.consumer.Consumer;
import org.example.mail.dto.NotificationDto;
import org.example.mail.service.MailService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerImpl implements Consumer {

    private final MailService mailService;

    private final ObjectMapper objectMapper;

    @Override
    public void consume(ConsumerRecord<String, String> record) {
        try {
            NotificationDto notificationDto = objectMapper.readValue(record.value(), NotificationDto.class);
            mailService.send(notificationDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
