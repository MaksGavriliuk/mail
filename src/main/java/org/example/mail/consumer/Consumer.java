package org.example.mail.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface Consumer {
    void consume(ConsumerRecord<String, String> record);
}
