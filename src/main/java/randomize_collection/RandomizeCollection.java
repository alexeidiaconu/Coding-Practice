package randomize_collection;
import java.util.ArrayList;
import java.util.HashMap;

public class RandomizeCollection {

    public  ArrayList<Integer> ArraySet; // the list of numbers
    public HashMap<Integer, ArrayList<Integer>> SearchCollection; // the key:value list of number: array of indexes where it's stored in the set

    public RandomizeCollection() {

        this.ArraySet = new ArrayList<> ();
        this.SearchCollection = new HashMap<>();
    }

    public boolean insert(int val) {
        if (SearchCollection.containsKey(val)) {

            ArraySet.add(val);
            int nextIndex = ArraySet.lastIndexOf(val);
            SearchCollection.get(val).add(nextIndex);
            return false;
        }
        ArrayList<Integer> index = new ArrayList<>();
        index.add(SearchCollection.size());
        ArraySet.add(val);
        SearchCollection.put(val,index);
        return true;
    }

    public boolean remove(int val) {
        if (! SearchCollection.containsKey(val)) {
            return false;
        }


        int index = SearchCollection.get(val).get(SearchCollection.get(val).size() - 1);
        SearchCollection.get(val).remove(index);
        int lastElement = ArraySet.get(ArraySet.size() - 1);
        ArraySet.set(index, lastElement);
        ArraySet.remove(ArraySet.size() - 1);
        SearchCollection.get(lastElement).add(index);
        if(SearchCollection.get(val).isEmpty()) {
            SearchCollection.remove(val);
        }
        return true;

//        int index = SearchCollection.get(val).get(0);
//        int lastElement = ArraySet.get(ArraySet.size() - 1);
//        ArraySet.set(index, lastElement);
//        ArraySet.remove(ArraySet.size() - 1);
//        SearchCollection.put(lastElement,index);
//        SearchCollection.remove(val);
//        return true;
    }

//    public int getRandom() {
//        int index = (int) (Math.random() * ArraySet.size());
//        return ArraySet.get(index);
//    }
//
//
//}

}
