
package org.example.testable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TestabilityTest {
    @Mock
    Logger logger;

    @Test
    void sendingMailWithInvalidEmailLogsError() {

        MailSender mailSender = mock(MailSender.class);
        doThrow(IllegalArgumentException.class).when(mailSender).sendMail(eq("some-invalid-email-address.com"),anyString());
        Testability testability = new Testability(logger, mailSender);

        testability.run();

        Mockito.verify(logger).log(LogLevel.WARNING,"Some warning - program is starting up or whatever");
        Mockito.verify(logger).log(eq(LogLevel.ERROR), startsWith("An error occurred:"));
    }

    @Test
    void checkValidEmail() {
        MailSender mailSender = mock(MailSender.class);
        Testability testability = new Testability(logger, mailSender);

        var answer = testability.isAdressValid("test@test.nu");

        assertTrue(answer);

    }


}

