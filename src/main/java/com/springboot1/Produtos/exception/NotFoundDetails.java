package com.springboot1.Produtos.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class NotFoundDetails {
    private String title;
    private int status;
    private String detail;
    private long timestamp;
    private String developerMessage;
}
