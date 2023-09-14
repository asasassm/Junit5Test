package main;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class DiceCalculator {

    public static int addDice(Dice a, Dice b) {

        return a.getNumber() + b.getNumber();
    }

    public static int subDice(Dice a, Dice b) {
        return Math.abs(a.getNumber() - b.getNumber());

    }

    public static int mulDice(Dice a, Dice b) {
        int result = a.getNumber() * b.getNumber();

        return result;
    }

    public static int divDice(Dice a, Dice b) {
        int result = a.getNumber() / b.getNumber();

        return result;
    }

    public static boolean isOdd(Dice a) {
        return a.getNumber() % 2 != 0;
    }

    public static boolean isEven(Dice a) {
        return a.getNumber() % 2 == 0;
    }

    private static Stream<Arguments> provideAddParams() {
        return Stream.of(Arguments.of(1, 2, 3));
    }
}
