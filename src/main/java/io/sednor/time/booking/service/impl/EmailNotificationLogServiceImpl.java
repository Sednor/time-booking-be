package io.sednor.time.booking.service.impl;

import io.sednor.time.booking.controller.dto.EmailNotificationLogDto;
import io.sednor.time.booking.repository.EmailNotificationLogRepository;
import io.sednor.time.booking.repository.entity.EmailNotificationLogEntity;
import io.sednor.time.booking.service.EmailNotificationLogService;
import io.sednor.time.booking.service.EmailNotificationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class EmailNotificationLogServiceImpl implements EmailNotificationLogService {

    private final EmailNotificationLogRepository emailNotificationLogRepository;
    private final EmailNotificationService emailNotificationService;

    @Override
    @Transactional
    public EmailNotificationLogDto createAndSend(EmailNotificationLogDto dto) {
        emailNotificationService.send(dto);
        EmailNotificationLogEntity saved = emailNotificationLogRepository.save(dto.toEntity());
        return saved.toDto();
    }

    @Override
    public Page<EmailNotificationLogDto> findAll(Pageable pageable) {
        Page<EmailNotificationLogEntity> page = emailNotificationLogRepository.findAll(pageable);
        return page.map(EmailNotificationLogEntity::toDto);
    }
}
