package com.example.notification_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class NotificationService {
    private final RestTemplate restTemplate;

    public NotificationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> getAllUsers() {
        String userServiceUrl = "http://user-service:8080/users";
        return restTemplate.getForObject(userServiceUrl, List.class);
    }

    public String notifyUsers() {
        List<Map<String, Object>> users = getAllUsers();
        return "Notified " + (users != null ? users.size() : 0) + " users.";
    }
}
