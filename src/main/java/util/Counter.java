package util;

public class Counter {

    private static int numberOfLoses = 0;

    public static void addLoses() {
        numberOfLoses++;
    }

    public static int getLoses() {
        return numberOfLoses;
    }

}
