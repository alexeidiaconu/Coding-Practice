package merge_two_arrays;

public class MergeTwoArrays {
    public int[] arr1;
    public int[] arr2;


    public void initArrays(int[] a1,int[] a2, int nrElem1, int nrElem2){
        if (nrElem1 + nrElem2 != a1.length) {
            System.out.println("Invalid Input Data");
            return;
        }
        arr1 = a1;
        arr2 = a2;

    }

    public void mergeArrays(){
        int j = 0;
        for (int i = arr1.length - arr2.length; i < arr1.length; i++) {
            if(arr1[i] == 0) {
                arr1[i] = arr2[j];
                j++;
            }
        }
        bubleSortArray(this.arr1);
    }

    public void bubleSortArray(int[] arr1) {
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr1.length - 1; i++) {
                int k = arr1[i];

                if (k > arr1[i + 1]) {
                    arr1[i] = arr1[i+1];
                    arr1[i+1] = k;
                    isSorted = false;
                }
            }
         }
    }
}
