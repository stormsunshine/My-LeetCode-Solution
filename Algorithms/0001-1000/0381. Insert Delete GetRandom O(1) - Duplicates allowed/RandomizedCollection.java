class RandomizedCollection {
    List<Integer> collection;
    Map<Integer, Set<Integer>> valueIndicesMap;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        collection = new ArrayList<Integer>();
        valueIndicesMap = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> indices = valueIndicesMap.getOrDefault(val, new LinkedHashSet<Integer>());
        indices.add(collection.size());
        valueIndicesMap.put(val, indices);
        collection.add(val);
        return indices.size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> indices = valueIndicesMap.getOrDefault(val, new LinkedHashSet<Integer>());
        if (indices.size() == 0)
            return false;
        else {
            int removeIndex = indices.iterator().next();
            indices.remove(removeIndex);
            valueIndicesMap.put(val, indices);
            int lastNum = collection.get(collection.size() - 1);
            collection.set(removeIndex, lastNum);
            Set<Integer> lastNumIndices = valueIndicesMap.getOrDefault(lastNum, new LinkedHashSet<Integer>());
            lastNumIndices.add(removeIndex);
            lastNumIndices.remove(collection.size() - 1);
            collection.remove(collection.size() - 1);
            return true;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int randomIndex = (int) (Math.random() * collection.size());
        return collection.get(randomIndex);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */