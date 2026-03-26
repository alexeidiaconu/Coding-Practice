package jump_game_test;

import best_time_to_buy_and_sell.BuyAndSell;
import jump_game.JumpGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class JumpGameTest {
    JumpGame jumpGame;

    @BeforeEach
    public void init() {
        jumpGame = new JumpGame();
    }

    @ParameterizedTest

    @MethodSource("testJumpGameFromStreams")

    public void testJumpGame(int[] steps, boolean expectedResult) {

        jumpGame.initArray(steps);
        Assertions.assertEquals(expectedResult,jumpGame.jumpGame());
    }

    @ParameterizedTest

    @MethodSource("testMinNrStepsFromStreams")

    public void testMinNrSteps(int[] steps, int expectedResult) {

        jumpGame.initArray(steps);
        Assertions.assertEquals(expectedResult,jumpGame.minNrSteps());
    }

    public static Stream<Arguments> testJumpGameFromStreams() {
        return Stream.of(
                Arguments.of((Object) new int[]{2,3,1,1,4}, true),
                Arguments.of((Object) new int[]{3,2,1,0,4}, false),
                Arguments.of((Object) new int[]{3, 5, 7, 8, 9, 3, 2, 1}, true),
                Arguments.of((Object) new int[]{9, 8, 7, 5, 3, 0, 0, 0}, true),
                Arguments.of((Object) new int[]{9, 3, 5, 7, 8, 0, 0, 0}, true),
                Arguments.of((Object) new int[]{1,2,3,4,5}, true),
                Arguments.of((Object) new int[]{3, 2, 1, 0, 0, 5}, false)
        );
    }

    public static Stream<Arguments> testMinNrStepsFromStreams() {
        return Stream.of(
                Arguments.of((Object) new int[]{2,3,1,1,4}, 2),
                Arguments.of((Object) new int[]{3, 5, 7, 8, 9, 3, 2, 1}, 2),
                Arguments.of((Object) new int[]{9, 8, 7, 5, 3, 0, 0, 0}, 1),
                Arguments.of((Object) new int[]{1, 3, 1, 0, 2, 0, 1, 0}, 4),
                Arguments.of((Object) new int[]{1,1,2,4,5}, 3)
        );
    }

}
