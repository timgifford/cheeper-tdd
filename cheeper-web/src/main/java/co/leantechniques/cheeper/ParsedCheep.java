package co.leantechniques.cheeper;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ParsedCheep {
    private String cheep;
    private List<String> mentionedUsers = new ArrayList<>();
    private List<String> hashTags = new ArrayList<>();

    private ParsedCheep(String cheep) {
        this.cheep = cheep;
    }

    public static ParsedCheep create(String cheep) {
        ParsedCheep parsedCheep = new ParsedCheep(cheep);
        parsedCheep.parseHashtags();
        parsedCheep.parseMentions();
        return parsedCheep;
    }

    public List<String> getMentionedUsers() {
        return mentionedUsers;
    }

    public List<String> getHashtags() {
        return hashTags;
    }

    public String getRawValue() {
        return cheep;
    }

    private void parseHashtags() {
        mentionedUsers = parse("@");
    }

    private void parseMentions() {
        hashTags = parse("#");
    }

    private List<String> parse(String prefix) {
        List<String> localTags = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(cheep, " ");
        while(tokenizer.hasMoreElements()){
            String token = tokenizer.nextToken();
            if(token.startsWith(prefix)) {
                localTags.add(token.substring(1));
            }
        }
        return localTags;
    }
}
