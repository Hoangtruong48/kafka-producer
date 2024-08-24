package com.appsdeveloperblogs.ws.productmicroservice.service;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCreatedEvent {
    String productId;
    String title;
    BigDecimal price;
    Integer quantity;
}
