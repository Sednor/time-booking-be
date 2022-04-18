package io.sednor.time.booking.repository.entity;

import io.sednor.time.booking.controller.dto.EmailNotificationLogDto;
import lombok.*;
import org.mockito.internal.util.collections.Sets;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "email_notification_log")
public class EmailNotificationLogEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private Long time;
    private LocalDateTime createdDate;
    private LocalDateTime dateTime;

    @Builder.Default
    @OneToMany(mappedBy = "emailNotificationLogEntity",
            cascade = CascadeType.PERSIST)
    private Set<ServiceEntity> services = Sets.newSet();

    public EmailNotificationLogDto toDto() {
        return EmailNotificationLogDto
                .builder()
                .id(this.id)
                .email(this.email)
                .time(this.time)
                .dateTime(this.dateTime)
                .createdDate(this.createdDate)
                .services(services.stream().map(ServiceEntity::toDto).collect(Collectors.toSet()))
                .build();
    }

    public void addService(ServiceEntity serviceEntity) {
        serviceEntity.setEmailNotificationLogEntity(this);
        services.add(serviceEntity);
    }
}
