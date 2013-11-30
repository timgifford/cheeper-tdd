package co.leantechniques.cheeper;

public interface Smtp {
    void send(String from, String to, String subject, String message);
}
