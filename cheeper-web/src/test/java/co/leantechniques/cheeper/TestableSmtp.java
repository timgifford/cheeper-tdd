package co.leantechniques.cheeper;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

public class TestableSmtp implements Smtp {
    private List<String> recipients = new ArrayList<>();

    @Override
    public void send(String from, String to, String subject, String message) {
        recipients.add(to);
    }

    public void assertContainsRecipient(String expectedEmailAddress) {
        assertThat(recipients, contains(expectedEmailAddress));
    }
}
