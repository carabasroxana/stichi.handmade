package com.stichi.handmade.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequestDto {
    private String name;
    private String description;
}
