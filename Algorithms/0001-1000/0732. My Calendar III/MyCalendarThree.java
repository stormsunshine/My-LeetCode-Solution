class MyCalendarThree {
    Map<Integer, Integer> countMap;

    public MyCalendarThree() {
        countMap = new TreeMap<Integer, Integer>();
    }
    
    public int book(int start, int end) {
        int startCount = countMap.getOrDefault(start, 0);
        int endCount = countMap.getOrDefault(end, 0);
        countMap.put(start, startCount + 1);
        countMap.put(end, endCount - 1);
        int maximumBook = 0;
        int bookCount = 0;
        Set<Integer> set = countMap.keySet();
        for (int key : set) {
            bookCount += countMap.get(key);
            maximumBook = Math.max(maximumBook, bookCount);
        }
        return maximumBook;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */