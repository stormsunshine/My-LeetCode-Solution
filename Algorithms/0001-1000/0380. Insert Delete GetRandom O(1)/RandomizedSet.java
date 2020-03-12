class RandomizedSet {
    Set<Integer> set;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return set.add(val);
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        List<Integer> list = new ArrayList<Integer>(set);
        int randomIndex = (int) (Math.random() * list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */