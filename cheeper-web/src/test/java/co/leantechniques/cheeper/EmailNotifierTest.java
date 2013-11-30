package co.leantechniques.cheeper;

import org.junit.Before;
import org.junit.Test;

public class EmailNotifierTest {

    private TestableSmtp mockSmtpEmailer = new TestableSmtp();
    private EmailNotifier emailSender;
    private CheepUserRepositoryInMemory cheepUserRepository;

    @Before
    public void setUp() throws Exception {
        cheepUserRepository = new CheepUserRepositoryInMemory();
        cheepUserRepository.save(TestObjectFactory.Users.Tim());

        emailSender = new EmailNotifier(mockSmtpEmailer, cheepUserRepository);
    }

    @Test
    public void sendEmailsToMentionedUsersNeedsToGetUsersEmail() {
        emailSender.sendEmailsToMentionedUsers("@timgifford is mentioned");

        mockSmtpEmailer.assertContainsRecipient("tim@leantechniques.co");
    }
}
