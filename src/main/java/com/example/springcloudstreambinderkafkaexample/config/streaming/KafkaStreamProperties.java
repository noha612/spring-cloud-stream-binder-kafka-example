package com.example.springcloudstreambinderkafkaexample.config.streaming;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.cloud.stream")
public class KafkaStreamProperties {
  private Long shutdownTimeout;

  public Long getShutdownTimeout() {
    return shutdownTimeout;
  }

  public void setShutdownTimeout(Long shutdownTimeout) {
    this.shutdownTimeout = shutdownTimeout;
  }
}
