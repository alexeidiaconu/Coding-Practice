package rotate_array;

public class RotateArray {

    public int[] elementsArray;

    public void initArray(int[] elements) {

        this.elementsArray = elements;
    }

    public void rotateArray(int steps) {

        int lastElement;
        int step = 0;
        while (step < steps) {

            lastElement = elementsArray[elementsArray.length - 1];

            for (int i = elementsArray.length - 1; i > 0; i--) {
                elementsArray[i] = elementsArray[i - 1];
            }

            elementsArray[0] = lastElement;
            step++;

        }

    }

}
