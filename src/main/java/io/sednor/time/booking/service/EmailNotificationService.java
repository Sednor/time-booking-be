package io.sednor.time.booking.service;

import io.sednor.time.booking.controller.dto.EmailNotificationLogDto;

public interface EmailNotificationService {

    void send(EmailNotificationLogDto emailNotificationLogDto);
}
