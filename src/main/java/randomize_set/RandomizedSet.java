package randomize_set;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomizedSet {
    public  ArrayList<Integer> ArraySet;
    public HashMap<Integer, Integer> SearchMap;

    public RandomizedSet() {

        this.ArraySet = new ArrayList<> ();
        this.SearchMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if (SearchMap.containsKey(val)) {
            return false;
        }
        int index = SearchMap.size();
        ArraySet.add(val);
        SearchMap.put(val,index);
        return true;
    }

    public boolean remove(int val) {
        if (! SearchMap.containsKey(val)) {
            return false;
        }
        int index = SearchMap.get(val);
        int lastElement = ArraySet.get(ArraySet.size() - 1);
        ArraySet.set(index, lastElement);
        ArraySet.remove(ArraySet.size() - 1);
        SearchMap.put(lastElement,index);
        SearchMap.remove(val);
        return true;
    }

    public int getRandom() {
        int index = (int) (Math.random() * ArraySet.size());
        return ArraySet.get(index);
    }


}
