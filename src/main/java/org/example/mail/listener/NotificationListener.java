package org.example.mail.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.mail.dto.NotificationDto;
import org.example.mail.service.MailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.example.mail.consumer.Consumer;

@Component
@RequiredArgsConstructor
public class NotificationListener {

    private final Consumer consumer;

    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    private void listen(ConsumerRecord<String, String> record) {
       consumer.consume(record);
    }

}