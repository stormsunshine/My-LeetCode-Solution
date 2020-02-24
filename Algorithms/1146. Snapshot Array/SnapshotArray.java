class SnapshotArray {
    TreeMap<Integer, Integer>[] maps;
    int totalSnapId;

    public SnapshotArray(int length) {
        maps = new TreeMap[length];
        for (int i = 0; i < length; i++)
            maps[i] = new TreeMap<Integer, Integer>();
        totalSnapId = 0;
    }
    
    public void set(int index, int val) {
        TreeMap<Integer, Integer> map = maps[index];
        map.put(totalSnapId, val);
        maps[index] = map;
    }
    
    public int snap() {
        totalSnapId++;
        return totalSnapId - 1;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> map = maps[index];
        Integer floorKey = map.floorKey(snap_id);
        if (floorKey == null)
            return 0;
        snap_id = floorKey;
        int value = map.getOrDefault(snap_id, 0);
        return value;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */