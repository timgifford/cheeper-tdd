package co.leantechniques.cheeper;

public class EmailNotifier implements Notifier {

    private CheepUserRepository cheepUserRepository;
    private Smtp emailer;

    public EmailNotifier(Smtp emailer, CheepUserRepository cheepUserRepository) {
        this.emailer = emailer;
        this.cheepUserRepository = cheepUserRepository;
    }

    @Override
    public void sendEmailsToMentionedUsers(String cheep) {

        ParsedCheep parsedCheep = ParsedCheep.create(cheep);
        for (String username : parsedCheep.getMentionedUsers()){
            CheepUser user = cheepUserRepository.getByUserName(username);
            emailer.send("support@cheeper.com", user.getEmail(), "You're mentioned in cheep", "a message");
        }
    }

}
