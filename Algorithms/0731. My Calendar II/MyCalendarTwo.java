class MyCalendarTwo {
    List<int[]> bookingList;
    List<int[]> overlapsList;

    public MyCalendarTwo() {
        bookingList = new ArrayList<int[]>();
        overlapsList = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] overlap : overlapsList) {
            if (overlap[0] < end && overlap[1] > start)
                return false;
        }
        int[] newInterval = {start, end};
        for (int[] booking : bookingList) {
            if (booking[0] < end && booking[1] > start) {
                int[] newOverlap = {Math.max(start, booking[0]), Math.min(end, booking[1])};
                overlapsList.add(newOverlap);
            }
        }
        bookingList.add(newInterval);
        Collections.sort(bookingList, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        Collections.sort(overlapsList, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */