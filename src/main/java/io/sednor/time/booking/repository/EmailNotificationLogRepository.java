package io.sednor.time.booking.repository;

import io.sednor.time.booking.repository.entity.EmailNotificationLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailNotificationLogRepository extends JpaRepository<EmailNotificationLogEntity, Integer> {
}
