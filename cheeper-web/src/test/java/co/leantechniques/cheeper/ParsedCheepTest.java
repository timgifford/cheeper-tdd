package co.leantechniques.cheeper;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class ParsedCheepTest {

    private String messageWithMentions;
    private ParsedCheep parsedCheep;

    @Before
    public void setUp() throws Exception {
        messageWithMentions = "@user1 @user2 there are 2 mentioned users #hashtag1 #hashtag2.";
        parsedCheep = ParsedCheep.create(messageWithMentions);
    }

    @Test
    public void getMentionedUsers() {
        assertThat(parsedCheep.getMentionedUsers().size(), is(2));
    }

    @Test
    public void getHashtags() {
        assertThat(parsedCheep.getHashtags().size(), is(2));
    }

    @Test
    public void removePrefixes() {
        assertThat(parsedCheep.getMentionedUsers().get(0), not(startsWith("@")));
        assertThat(parsedCheep.getHashtags().get(0), not(startsWith("#")));
    }

    @Test
    public void getRawCheep() {
        assertThat(parsedCheep.getRawValue(), is(messageWithMentions));
    }

}
