package best_time_to_buy_and_sell_test;

import best_time_to_buy_and_sell.BuyAndSell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BuyAndSellTest {

    public BuyAndSell buyAndSell;

    @BeforeEach
    public void init() {

        buyAndSell = new BuyAndSell();
    }

    @ParameterizedTest

    @MethodSource("testBestProfitFromStreams")

    public void testBestProfit(int[] prices, int expectedProfit) {

        buyAndSell.initArray(prices);

        Assertions.assertEquals(expectedProfit,buyAndSell.maxProfit());

    }

    @ParameterizedTest

    @MethodSource("testBestProfitFromStreams")

    public void testCumulatedProfit(int[] prices, int expectedProfit) {

        buyAndSell.initArray(prices);

        Assertions.assertEquals(expectedProfit,buyAndSell.cumulatedProfit());

    }

    public static Stream<Arguments> testBestProfitFromStreams() {
        return Stream.of(
                Arguments.of((Object) new int[]{3, 5, 7, 8, 9, 3, 2, 1}, 6),
                Arguments.of((Object) new int[]{9, 8, 7, 5, 3, 0, 0, 0}, 0),
                Arguments.of((Object) new int[]{9, 3, 5, 7, 8, 0, 0, 0}, 5),
                Arguments.of((Object) new int[]{7,1,5,3,6,4}, 7),
                Arguments.of((Object) new int[]{1,2,3,4,5}, 4),
                Arguments.of((Object) new int[]{3, 8, 1, 4, 7, 5}, 11)
        );
    }
}
