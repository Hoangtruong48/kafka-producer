package com.appsdeveloperblogs.ws.productmicroservice.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductRestModel {
    String title;
    BigDecimal price;
    Integer quantity;
}
