package co.leantechniques.cheeper;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// 1. Send Cheep (Refactoring)
// 2. Cheep too long (logic)
// 3. Send emails to mentioned users (Dependencies)

public class CheeperServerTest {
    private CheeperController controller;
    private TestableNotifier emailSender;

    @Before
    public void setUp() throws Exception {
        emailSender = new TestableNotifier();
        controller = new CheeperController(emailSender);
    }

    @Test
    public void sendCheep() {
        controller.send("Hello there");

        Collection<String> allCheeps = controller.getAllCheeps();
        assertEquals(true,  allCheeps.contains("Hello there"));
    }

    @Test(expected = CheepTooLongException.class)
    public void longCheepThrowsException() {
        controller.send(TestObjectFactory.createCheep(151));
    }

    @Test
    public void sendEmailsToMentionedUsers() {
        controller.send("this will send emails to @tim and @jen");

        

        assertTrue(emailSender.sendEmailsToMentionedUsersWasCalled());
    }
}
