package io.sednor.time.booking.controller.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.sednor.time.booking.repository.entity.EmailNotificationLogEntity;
import io.sednor.time.booking.repository.entity.ServiceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mockito.internal.util.collections.Sets;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailNotificationLogDto implements Serializable {
    private Integer id;
    private String email;
    private Long time;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTime;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdDate;
    private Set<ServiceDto> services = Sets.newSet();

    public EmailNotificationLogEntity toEntity() {
        EmailNotificationLogEntity emailNotificationLogEntity = EmailNotificationLogEntity
                .builder()
                .id(this.id)
                .email(this.email)
                .time(this.time)
                .dateTime(this.dateTime)
                .createdDate(LocalDateTime.now())
                .build();
        services.forEach(item -> emailNotificationLogEntity.addService(item.toEntity()));
        return emailNotificationLogEntity;
    }
}
