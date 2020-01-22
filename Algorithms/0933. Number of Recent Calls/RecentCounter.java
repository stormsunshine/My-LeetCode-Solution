class RecentCounter {
    List<Integer> pingsList;
    int startIndex;
    int size;

    public RecentCounter() {
        pingsList = new ArrayList<Integer>();
        startIndex = 0;
        size = 0;
    }
    
    public int ping(int t) {
        pingsList.add(t);
        size++;
        while (t - pingsList.get(startIndex) > 3000)
            startIndex++;
        return size - startIndex;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */