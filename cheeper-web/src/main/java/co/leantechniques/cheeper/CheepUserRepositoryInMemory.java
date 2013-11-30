package co.leantechniques.cheeper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CheepUserRepositoryInMemory implements CheepUserRepository{
    private Map<String, CheepUser> users = new HashMap<>();

    @Override
    public void save(CheepUser cheepUser) {
        users.put(cheepUser.getUsername(), cheepUser);
    }

    @Override
    public Collection<CheepUser> getAll(){
        return users.values();
    }

    @Override
    public CheepUser getByUserName(String username) {
        return users.get(username);
    }
}
