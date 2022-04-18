package io.sednor.time.booking.service.impl;

import io.sednor.time.booking.service.EmailNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

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
    public void send(String email) {
        try {
            log.info("Prepare to send an email {}", email);
            MimeMessageHelper messageHelper = new MimeMessageHelper(emailSender.createMimeMessage(), true, "UTF-8");
            messageHelper.setSubject("Email for demo purpose!");
            messageHelper.setFrom(sender);
            messageHelper.setText(context, true);
            messageHelper.setTo(email);
            emailSender.send(messageHelper.getMimeMessage());
            log.info("Email sent to {}", email);
        } catch (Exception e) {
            log.debug("Failed to send an email. ", e);
            throw new RuntimeException(e);
        }
    }
}
