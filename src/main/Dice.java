package main;

public class Dice {
    private int num;

    public Dice(int random) {
        if (random < 0 || random > 7) {
            throw new IllegalArgumentException("1미만 6 초과 안됨");
        }
        num = random;
        System.out.println("다이스 숫자 : " + num);

    }

    public int getNumber() {
        return num;
    }

}
