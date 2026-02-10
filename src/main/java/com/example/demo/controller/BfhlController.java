package com.example.demo.controller;

import com.example.demo.service.BfhlService;
import com.example.demo.model.ApiResponse;
import com.example.demo.exception.BadRequestException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class BfhlController {

    private final BfhlService bfhlService;

    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @PostMapping("/bfhl")
    public ResponseEntity<ApiResponse> handleRequest(
            @RequestBody Map<String, Object> request) {

        if (request == null || request.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.failure("Request body is empty"));
        }

        if (request.size() != 1) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.failure("Only one key is allowed"));
        }

        Iterator<String> iterator = request.keySet().iterator();
        String key = iterator.next().toLowerCase();
        Object value = request.get(key);

        Object result = bfhlService.process(key, value);

        return ResponseEntity.ok(ApiResponse.success(result));
    }

    @GetMapping("/health")
    public ResponseEntity<ApiResponse> health() {
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
