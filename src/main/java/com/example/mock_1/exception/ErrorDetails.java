package com.example.mock_1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorDetails {
    private HttpStatus status;
    private String message;
    private String detail;

    public ErrorDetails(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }
}
