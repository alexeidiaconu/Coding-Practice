package rotate_array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateArray {

    public int[] elementsArray;

    public void initArray(int[] elements) {

        this.elementsArray = elements;
    }

    public void reverseArray(int start, int end) {

        while (start < end) {
            int temp = elementsArray[start];
            elementsArray[start] = elementsArray[end];
            elementsArray[end] = temp;
            start++;
            end--;
        }
    }

    public void rotateArray(int steps) {

        steps = steps % elementsArray.length;

        reverseArray(0, elementsArray.length - 1);
        reverseArray(0, steps - 1);
        reverseArray(steps, elementsArray.length - 1);


        for (int i = 0; i < elementsArray.length; i++) {
            System.out.print(elementsArray[i] + " ");
        }
        System.out.println();
    }

    public void rotateArray2(int steps) {

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
