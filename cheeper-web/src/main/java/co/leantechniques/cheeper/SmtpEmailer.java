package co.leantechniques.cheeper;

class SmtpEmailer implements Smtp {
    public void send(String from, String to, String subject, String message) {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
