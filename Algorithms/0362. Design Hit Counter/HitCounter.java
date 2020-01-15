class HitCounter {
    static final int INTERVAL = 300;
    List<Integer> hitsList;
    int size;

    /** Initialize your data structure here. */
    public HitCounter() {
        hitsList = new ArrayList<Integer>();
        size = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        hitsList.add(timestamp);
        size++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if (timestamp <= INTERVAL)
            return size;
        else
            return size - binarySearch(timestamp);
    }

    public int binarySearch(int timestamp) {
        int begin = timestamp - INTERVAL + 1;
        if (begin <= 0)
            return 0;
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = hitsList.get(mid);
            if (num == begin)
                return mid;
            else if (num > begin)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */