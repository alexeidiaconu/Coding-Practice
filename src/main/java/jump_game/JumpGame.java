package jump_game;

public class JumpGame {

    public int[] elementsArray;

    public void initArray(int[] elements) {

        this.elementsArray = elements;
    }

    public boolean jumpGame() {
        int goal = elementsArray.length - 1;

        for (int i = elementsArray.length - 1; i >= 0; i--) {
            if (i + elementsArray[i] >= goal) {
                goal = i;
            }
        }
        if (goal == 0) {
            return true;
        }
        return false;
    }

    public int minNrSteps() {

        int left = 0;
        int right = 0;
        int steps = 0;
        int farthest = 0;

        while (right < elementsArray.length - 1) {
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + elementsArray[i]);
            }
            left =  right + 1;
            right = farthest;
            steps++;
        }
        return steps;
    }
}
