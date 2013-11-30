package co.leantechniques.cheeper;

public interface CheepUserRepository extends  Repository<CheepUser> {
    CheepUser getByUserName(String username);
}
