package pl.tomaszdziurko.jvm_bloggers.mailing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev", "test"})
@Slf4j
@Getter
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LogMailSender implements MailSender {

    private final MailPostAction mailPostAction;

    @Override
    public void sendEmail(String recipientAddress, String subject, String htmlContent) {
        log.debug("Sending email to '{}'\nSubject: {}\n{}", recipientAddress, subject, htmlContent);
        mailPostAction.postAction();
    }
}