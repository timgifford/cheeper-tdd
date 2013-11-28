package co.leantechniques.cheeper;

import com.google.common.base.Strings;

public class TestObjectFactory {
    public static String createCheep(int numberOfCharacters) {
        return Strings.repeat("a", numberOfCharacters);
    }
}
