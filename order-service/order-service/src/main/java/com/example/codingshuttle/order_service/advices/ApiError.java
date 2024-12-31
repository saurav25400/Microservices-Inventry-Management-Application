package com.example.codingshuttle.order_service.advices;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ApiError {
    private String message;
    private LocalDateTime timestamp;
    private HttpStatusCode httpStatusCode;
}
