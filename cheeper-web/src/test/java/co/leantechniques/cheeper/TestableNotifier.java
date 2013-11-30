package co.leantechniques.cheeper;

public class TestableNotifier implements Notifier {
    private boolean wasCalled = false;

    @Override
    public void sendEmailsToMentionedUsers(String cheep) {
        wasCalled = true;
    }

    public boolean sendEmailsToMentionedUsersWasCalled() {
        return wasCalled;
    }
}
