package co.leantechniques.cheeper;

import com.google.common.base.Strings;

public class TestObjectFactory {
    public static String createCheep(int numberOfCharacters) {
        return Strings.repeat("a", numberOfCharacters);
    }

    public static class Users {
        public static CheepUser Tim() {
            return new CheepUser("timgifford", "tim@leantechniques.co");
        }
    }
}
