package io.sednor.time.booking.controller.dto;

import io.sednor.time.booking.repository.entity.ServiceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto implements Serializable {

    private Integer id;
    private String serviceName;

    public ServiceEntity toEntity() {
        return ServiceEntity
                .builder()
                .id(this.id)
                .serviceName(this.serviceName)
                .build();
    }

}
