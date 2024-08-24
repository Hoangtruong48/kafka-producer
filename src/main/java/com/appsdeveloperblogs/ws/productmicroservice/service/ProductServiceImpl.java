package com.appsdeveloperblogs.ws.productmicroservice.service;

import com.appsdeveloperblogs.ws.productmicroservice.model.CreateProductRestModel;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductServiceImpl implements ProductService {
    @Value("${event.product.topic-create.name}")
    String topicName;
    final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    @Override
    public String createProduct(CreateProductRestModel product) {
        String productId = UUID.randomUUID().toString();
        // TODO: persist product in db

        ProductCreatedEvent productCreatedEvent = ProductCreatedEvent
                .builder()
                .productId(productId)
                .price(product.getPrice())
                .title(product.getTitle())
                .quantity(product.getQuantity())
                .build();

        CompletableFuture<SendResult<String, ProductCreatedEvent>> future =
                kafkaTemplate.send(topicName, productId, productCreatedEvent);
        future.whenComplete((result, exception) -> {
            if (exception != null){
                LOGGER.error(exception.getMessage());
            } else {
                LOGGER.info("Product created successfully : {}", result.getRecordMetadata());
            }
        });
        LOGGER.info("***Product Id : {} ***", productId);

        return productId;
    }
}
