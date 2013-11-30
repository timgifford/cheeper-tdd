package co.leantechniques.cheeper;

import java.util.Collection;

public class CheeperController {

    private final CheepRepository cheepRepositoryInMemory = new CheepRepositoryInMemory();
    private Notifier notifier;

    public CheeperController(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String cheep) {
        if(cheep.length() > 150) throw new CheepTooLongException();
        notifier.sendEmailsToMentionedUsers(cheep);
        cheepRepositoryInMemory.save(cheep);
    }

    public Collection<String> getAllCheeps() {
        return cheepRepositoryInMemory.getAll();
    }
}
