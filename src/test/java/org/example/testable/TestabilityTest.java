package org.example.testable;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TestabilityTest {

     @Mock
     Logger logger; //mock object can be a field or instantiated within a method as below. Both behaves as a dummy with default variable values

    @Test
    void sendingMainWithInvalidEmailLogsError() {
        //Logger logger = mock(Logger.class);
        MailSender mailSender = mock(MailSender.class);

        //teaching mock object to return specific output for a given scenario
        doThrow(IllegalArgumentException.class).when(mailSender).sendMail(eq("some-invalid-email-address.com"), anyString());
        //"invalid-email-address.com" can be replaced with matches(regex)

        Testability testability = new Testability(logger, mailSender);

        //run
        testability.run();

        Mockito.verify(logger).log(LogLevel.WARNING, "Some warning - program is starting up or whatever");
        Mockito.verify(logger).log(eq(LogLevel.ERROR), startsWith("An error occurred: "));
        Mockito.verify(logger, times(2)).log(any(), any()); //verify # of times logger is invoked
        // avoid this -> unstable tests if implementation is changed. Rather test output (log messages)
    }

    @Test
//    @Disabled("Current bug that will be fixed when issue #23 is fixed")   //@DisabledOnOs(OS.MAC)  => ignored tests should have an explanation (comment)
   @Tag("dev")
    void checkValidEmail() {
        MailSender mailSender = mock(MailSender.class);
        Testability testability = new Testability(logger, mailSender);
        //objects are simply required in Construcotr & they don't beome studbs or

        boolean answer = testability.isValidEmail("test@test.nu");

        assertTrue(answer);
    }

}