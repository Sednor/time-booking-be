package io.sednor.time.booking.service.impl;

import io.sednor.time.booking.controller.dto.EmailNotificationLogDto;
import io.sednor.time.booking.controller.dto.ServiceDto;
import io.sednor.time.booking.service.EmailNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {
    @Autowired
    private JavaMailSender emailSender;
    @Value("${email.from}")
    private String sender;
    @Value("${email.template}")
    private String context;

    @Override
    public void send(EmailNotificationLogDto dto) {
        try {
            log.info("Prepare to send an email {}", dto.getEmail());
            MimeMessageHelper messageHelper = new MimeMessageHelper(emailSender.createMimeMessage(), true, "UTF-8");
            messageHelper.setSubject("Services Booked!");
            messageHelper.setFrom(sender);
            Set<String> services = dto.getServices().stream().map(ServiceDto::getServiceName).collect(Collectors.toSet());
            messageHelper.setText("You have successfully booked the following services: " + services);
            messageHelper.setTo(dto.getEmail());
            emailSender.send(messageHelper.getMimeMessage());
            log.info("Email sent to {}", dto.getEmail());
        } catch (Exception e) {
            log.debug("Failed to send an email. ", e);
            throw new RuntimeException(e);
        }
    }
}
