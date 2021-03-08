package com.example.springcloudstreambinderkafkaexample.config.streaming;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.config.ListenerContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@ConditionalOnExpression("${spring.cloud.stream.enabled:true}")
@EnableBinding({PolAccumulationBinding.class})
@EnableConfigurationProperties(KafkaStreamProperties.class)
@SuppressWarnings("squid:S3740")
public class EventStreamConfig {

  @Bean
  ListenerContainerCustomizer listenerContainerCustomizer(
      KafkaStreamProperties kafkaStreamProperties) {
    return (container, destinationName, group) -> {
      if (container instanceof ConcurrentMessageListenerContainer) {
        ((ConcurrentMessageListenerContainer) container).getContainerProperties()
            .setShutdownTimeout(kafkaStreamProperties.getShutdownTimeout());
      }
    };
  }

}
