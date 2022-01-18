package org.example.testable;

public class Testability {

    private Logger logger;
    private MailSender mailSender;

    //this class is testable -> it uses dependency injection in its constructor
    public Testability(Logger logger, MailSender mailSender) {
        this.logger = logger;
//        if(mailSender == null)    //possible null check
//            throw new IllegalArgumentException();
        this.mailSender = mailSender;
    }

    public static void main(String[] args) {
        new Testability(new RealLogger(), new RealMailSender()).run();
    }

    public void run() {
        try {
            logger.log(LogLevel.WARNING, "Some warning - program is starting up or whatever");
            mailSender.sendMail("some-invalid-email-address.com", "Program has started.");
        } catch (IllegalArgumentException ex) {
            logger.log(LogLevel.ERROR, "An error occurred: " + ex);
        }
    }

    public boolean isValidEmail(String s) {

        return s.contains("@");
    }
}

