package com.example.springai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<Map<String, String>> chat(@RequestParam String query) {
        try {
            // Option 1: Simple call
            // String resultResponse = chatClient.call(query).getResult().getOutput().getContent();

            // Option 2: Using Prompt object
            Prompt prompt = new Prompt(query);
            String resultResponse = chatClient.prompt(prompt).call().content();

            return ResponseEntity.ok(Map.of("query", query, "response", resultResponse));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }
}
