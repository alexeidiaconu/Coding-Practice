package remove_triplicates;

import java.util.Arrays;

public class RemoveTriplicates {

    public int[] elementsArray;

    public void initArray(int[] elements) {

        this.elementsArray = elements;
    }


    public int removeTriplicates2 () {

        if (elementsArray.length == 0) {
            return 0;
        }
        Arrays.sort(this.elementsArray);

        int idx = 0;
        int currentElement = elementsArray[0];
        int nrOcc = 1;


        for (int i = 1; i < elementsArray.length; i++) {

            if (elementsArray[i] == currentElement) {

                if (nrOcc < 2) {
                    idx++;
                    elementsArray[idx] = elementsArray[i];
                }
                nrOcc++;

            }

            if (elementsArray[i] != currentElement) {

                idx++;
                elementsArray[idx] = elementsArray[i];
                currentElement = elementsArray[i];
                nrOcc = 1;

            }
        }

        elementsArray = Arrays.copyOf(elementsArray,idx + 1);
        return idx + 1;

    }

    public int removeTriplicates () {

        if (elementsArray.length == 0) {
            return 0;
        }
        Arrays.sort(this.elementsArray);

        int idx = 0;
        int nrOcc = 1;
        int currentElement = elementsArray[0];
        int maxOcc = 2;

        for (int i = 1; i < elementsArray.length; i++) {
            if ((elementsArray[i] != currentElement) || (nrOcc < maxOcc)) {

                idx++;

                elementsArray[idx] = elementsArray[i];

                if (elementsArray[i] != currentElement) {

                    currentElement = elementsArray[i];
                    nrOcc = 1;

                } else {
                    nrOcc ++;
                }
            }
        }

        elementsArray = Arrays.copyOf(elementsArray,idx + 1);

//        for(int j = 0; j < elementsArray.length; j++) {
//            System.out.print(elementsArray[j] + " ");
//        }
//        System.out.println(" ");
        return idx + 1;
    }

}
