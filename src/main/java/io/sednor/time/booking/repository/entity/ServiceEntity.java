package io.sednor.time.booking.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "service")
public class ServiceEntity {

    @Id
    private Integer id;

    private String serviceName;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "email_notification_log_id")
    private EmailNotificationLogEntity emailNotificationLogEntity;

}
