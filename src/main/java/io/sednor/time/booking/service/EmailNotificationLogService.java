package io.sednor.time.booking.service;

import io.sednor.time.booking.controller.dto.EmailNotificationLogDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmailNotificationLogService {
    EmailNotificationLogDto createAndSend(EmailNotificationLogDto dto);
    Page<EmailNotificationLogDto> findAll(Pageable pageable);
}
