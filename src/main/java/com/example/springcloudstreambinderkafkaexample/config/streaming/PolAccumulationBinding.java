package com.example.springcloudstreambinderkafkaexample.config.streaming;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PolAccumulationBinding {

  @Output("PRODUCER_EXAMPLE")
  MessageChannel producer();

  @Input("CONSUMER_EXAMPLE")
  SubscribableChannel consumer();
}
