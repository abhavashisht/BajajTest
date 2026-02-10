package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private boolean is_success;
    private String official_email;
    private Object data;
    private String error;

    public static ApiResponse success(Object data) {
        ApiResponse response = new ApiResponse();
        response.is_success = true;
        response.official_email = "abha1673.be23@chitkara.edu.in";
        response.data = data;
        return response;
    }

    public static ApiResponse failure(String error) {
        ApiResponse response = new ApiResponse();
        response.is_success = false;
        response.error = error;
        return response;
    }
}
