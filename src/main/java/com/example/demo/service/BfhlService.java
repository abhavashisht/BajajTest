package com.example.demo.service;

import com.example.demo.client.AiClient;
import com.example.demo.exception.BadRequestException;

import org.springframework.stereotype.Service;

@Service
public class BfhlService {

    private final AiClient aiClient;

    public BfhlService(AiClient aiClient) {
        this.aiClient = aiClient;
    }

    public Object process(String key, Object value) {

        String prompt;

        switch (key) {

            case "fibonacci":
                prompt = "Return only fibonacci series till " + value;
                break;

            case "prime":
                prompt = "Return only prime numbers from " + value;
                break;

            case "lcm":
                prompt = "Return only lcm of " + value;
                break;

            case "hcf":
                prompt = "Return only hcf of " + value;
                break;

            case "ai":
                prompt = value.toString();
                break;

            default:
                throw new BadRequestException("Invalid key");
        }

        return aiClient.callAI(prompt);
    }
}
