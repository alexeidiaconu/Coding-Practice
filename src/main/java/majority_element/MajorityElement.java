package majority_element;

import java.util.Arrays;

public class MajorityElement {

    public int[] elementsArray;

    public void initArray(int[] elements) {

        this.elementsArray = elements;
    }

    public int findMajorityElement() {

        int votes = 0;
        int candidate = 0;

        for (int element : elementsArray) {

            if (votes == 0) {
                candidate = element;
            }

            if (element == candidate) {
                votes++;
            } else {
                votes--;
                }
        }
        return  candidate;
    }

    public int findHIndex2() {
        int hIndex = 0;
        Arrays.sort(elementsArray);

        for (int i  = 0; i <= elementsArray.length - 1; i++) {

            if (elementsArray[elementsArray.length - 1 - i] >= i + 1 ) {
                hIndex = i+1;
            }
        }
        return hIndex;
    }

    public int findHIndex() {

        int hIndex = 0;
        Arrays.sort(elementsArray);

        for (int i  = 0; i < elementsArray.length ; i++) {

            hIndex = elementsArray.length -i;

            if (elementsArray[i] >= hIndex) {

                return hIndex;
            }
        }
        return 0;
    }


}
