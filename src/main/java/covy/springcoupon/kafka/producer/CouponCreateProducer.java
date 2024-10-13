package covy.springcoupon.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CouponCreateProducer {

    private static final String TOPIC_NAME = "coupon-create";
    private final KafkaTemplate<String, Long> kafkaTemplate;

    public void create(Long userId) {
        kafkaTemplate.send(TOPIC_NAME, userId);
        log.info("메세지 발행 성공, topicName: {}, userId: {}", TOPIC_NAME, userId);
    }


}
