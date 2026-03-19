package remove_element;

public class RemoveElement {

    public int[] elementArray;

    public void initElements(int[] elements) {
        this.elementArray = elements;
    }

    public int removeElement(int element) {
        if (element == -1) {
            System.out.println("Please provide positive int values!");
            return -1;
        }

        int last = elementArray.length;

        for (int i = 0; i < elementArray.length; i++) {
            if (elementArray[i] == element) {
                for (int j = i+1; j < last; j++) {
                    elementArray[j-1] = elementArray[j];
                }
                elementArray[last-1] = -1;
                last--;
                i--;
            }
        }
        return  elementArray.length - last;

    }
}
