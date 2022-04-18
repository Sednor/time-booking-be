package io.sednor.time.booking.controller.dto;

import io.sednor.time.booking.repository.entity.EmailNotificationLogEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EmailNotificationLogDto {
    private Integer id;
    private String email;
    private Long time;
    private LocalDateTime createdDate;

    public EmailNotificationLogEntity toEntity(){
        return EmailNotificationLogEntity
                .builder()
                .id(this.id)
                .email(this.email)
                .time(this.time)
                .createdDate(this.createdDate)
                .build();
    }
}
