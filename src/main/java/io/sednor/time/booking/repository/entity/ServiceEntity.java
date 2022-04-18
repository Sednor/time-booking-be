package io.sednor.time.booking.repository.entity;

import io.sednor.time.booking.controller.dto.EmailNotificationLogDto;
import io.sednor.time.booking.controller.dto.ServiceDto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = "emailNotificationLogEntity")
@Table(name = "service")
public class ServiceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String serviceName;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "email_notification_log_id")
    private EmailNotificationLogEntity emailNotificationLogEntity;

    public ServiceDto toDto() {
        return ServiceDto
                .builder()
                .id(this.id)
                .serviceName(this.serviceName)
                .build();
    }

}
