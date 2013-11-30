package co.leantechniques.cheeper;

public class CheepUser {
    private String username;
    private String email;

    public CheepUser(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
