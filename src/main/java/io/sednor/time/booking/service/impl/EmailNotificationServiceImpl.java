package io.sednor.time.booking.service.impl;

import com.sendgrid.*;
import io.sednor.time.booking.service.EmailNotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {
    @Value("${email.from}")
    private String sender;
    @Value("${email.template}")
    private String content;
    @Autowired
    private SendGrid sendGrid;

    @Override
    public void send(String email) {
        try {

            log.info("Prepare to send an email {}", email);

            Email from = new Email(sender);
            Email to = new Email(email);
            Mail mail = new Mail(from, "Email for demo purpose!", to, new Content("text/html", content));

            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sendGrid.api(request);
            log.info("Email sent to {}", email);
        } catch (Exception e) {
            log.debug("Failed to send an email. ", e);
            throw new RuntimeException(e);
        }
    }
}
