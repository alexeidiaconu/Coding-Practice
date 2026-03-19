package remove_duplicates;

import java.util.Arrays;

public class RemoveDuplicates {

    public int[] elementsArray;

    public void initArray(int[] elements) {
        this.elementsArray = elements;
    }

    public int removeDuplicates () {
        if (elementsArray.length == 0) {
            return 0;
        }
        Arrays.sort(elementsArray);
        int j = 0;
        for (int i = 1; i < elementsArray.length; i++) {

            if(elementsArray[i] != elementsArray[j]) {
                j++;
                elementsArray[j] = elementsArray[i];
            }
        }
        elementsArray = Arrays.copyOf(elementsArray,j + 1);
        return j+1;
    }
}
