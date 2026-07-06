package se.lexicon;

public class CoinValidator {

    private static final int[] validCoins = {1, 2, 5, 10, 20, 50};

    public static boolean isValidCoin(int coin) {
        for (int c : validCoins) {
            if (c == coin) return true;
        }
        return false;
    }
}
