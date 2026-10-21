public class HIndexBucket {

    public static int hIndex(int[] citations) {
        int n = citations.length;

        // Step 1: create buckets
        int[] buckets = new int[n + 1];

        // Step 2: fill buckets
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++;   // cap everything >= n
            } else {
                buckets[c]++;
            }
        }

        // Step 3: traverse from right to left
        int total = 0;

        for (int i = n; i >= 0; i--) {
            total += buckets[i];  // papers with >= i citations

            if (total >= i) {
                return i;         // found the h-index
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citations)); // Output: 3
    }
}

