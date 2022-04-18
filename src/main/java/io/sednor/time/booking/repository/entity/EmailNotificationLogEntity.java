package io.sednor.time.booking.repository.entity;

import io.sednor.time.booking.controller.dto.EmailNotificationLogDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "email_notification_log")
public class EmailNotificationLogEntity {
    @Id
    private Integer id;
    private String email;
    private Long time;
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "emailNotificationLogEntity",
            cascade = CascadeType.PERSIST)
    private Set<ServiceEntity> serviceEntity;

    public EmailNotificationLogDto toDto() {
        return EmailNotificationLogDto
                .builder()
                .id(this.id)
                .email(this.email)
                .time(this.time)
                .createdDate(this.createdDate)
                .build();
    }
}
