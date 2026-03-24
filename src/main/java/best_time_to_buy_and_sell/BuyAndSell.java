package best_time_to_buy_and_sell;

public class BuyAndSell {

    public int[] elementsArray;

    public void initArray(int[] elements) {

        this.elementsArray = elements;
    }

    public int maxProfit() {
        int maxProfit = 0;

        int buy = elementsArray[0];
        int sell = 0;

        for (int i = 1; i < elementsArray.length; i++) {
            sell = elementsArray[i];
            if (sell > buy) {
                maxProfit = Math.max(maxProfit, sell - buy);
            } else {
                buy = sell;
            }
        }
        return maxProfit;
    }
}
