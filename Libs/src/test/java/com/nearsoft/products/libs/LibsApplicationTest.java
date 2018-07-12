package com.nearsoft.products.libs;

import com.nearsoft.products.libs.kafka.Consumer;
import com.nearsoft.products.libs.kafka.Producer;
import org.assertj.core.api.Assertions;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ComponentScan("com.nearsoft.products.libs")
@SpringBootTest
public class LibsApplicationTest {

    private static String BOOT_TOPIC = "products";

    @Autowired
    private Producer producer;

    @Autowired
    private Consumer consumer;

    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, BOOT_TOPIC);

    @Test
    public void testReceive() throws Exception {
        producer.send(BOOT_TOPIC, "Libs Test");

        consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertThat(consumer.getLatch().getCount()).isEqualTo(0);
    }
}
