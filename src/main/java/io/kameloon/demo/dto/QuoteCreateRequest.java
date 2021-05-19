package io.kameloon.demo.dto;

import lombok.Data;

@Data
public class QuoteCreateRequest {
    private String title;
    private String text;
    private String author;
}
