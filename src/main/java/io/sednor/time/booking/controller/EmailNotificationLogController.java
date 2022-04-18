package io.sednor.time.booking.controller;

import io.sednor.time.booking.controller.dto.EmailNotificationLogDto;
import io.sednor.time.booking.service.EmailNotificationLogService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/email-notification-log")
public class EmailNotificationLogController {

    private final EmailNotificationLogService emailNotificationLogService;

    @PostMapping
    public ResponseEntity<EmailNotificationLogDto> createAndSend(@RequestBody EmailNotificationLogDto dto) {
        return ResponseEntity.ok(emailNotificationLogService.createAndSend(dto));
    }

    @GetMapping
    public ResponseEntity<Page<EmailNotificationLogDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(emailNotificationLogService.findAll(pageable));
    }
}
