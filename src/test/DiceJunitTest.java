package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import main.Dice;
import main.DiceCalculator;

@TestInstance(Lifecycle.PER_CLASS)
public class DiceJunitTest {
    private Dice first;
    private Dice second; // 다 같이 사용하기 위해

    // 여러번 사용 위해
    @BeforeEach
    void setUp() {
        first = new Dice(6);
        second = new Dice(2);
    }

    // test는 주로 void로 쓴다
    @Test
    @DisplayName("addDice 성공")
    void addDice() {
        assertEquals(DiceCalculator.addDice(first, second), 8);
    }

    @Test
    @DisplayName("음수 값의 주사위를 생성할수 없을때 IllegalArgumentException")
    void negativeDice_throwIllegalArgumentException() {
        Exception exceoption = assertThrows(IllegalArgumentException.class, () -> new Dice(-1));
        assertEquals(exceoption.getMessage(), "1미만 6 초과 안됨");
    }

    @Test
    @DisplayName("subDice 성공")
    void subDice() {
        assertEquals(DiceCalculator.subDice(first, second), 4);
    }

    @ParameterizedTest
    @MethodSource("provideAddParams")
    @DisplayName("여러번 더해보는")
    void add_success(int a, int b, int c) {
        assertEquals(DiceCalculator.addDice(new Dice(a), new Dice(b)), c);
    }

    //
    @AfterAll
    void done() {
        System.out.println("done");
    }
}
