package majority_element;

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
}
