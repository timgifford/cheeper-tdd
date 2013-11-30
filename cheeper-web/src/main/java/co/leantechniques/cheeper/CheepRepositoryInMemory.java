package co.leantechniques.cheeper;

import java.util.ArrayList;
import java.util.List;

public class  CheepRepositoryInMemory implements CheepRepository {
    ArrayList<String> cheepList = new ArrayList<String>();

    public CheepRepositoryInMemory() {
    }

    public void save(String cheep) {
        cheepList.add(cheep);
    }

    public List<String> getAll() {
        return cheepList;
    }
}