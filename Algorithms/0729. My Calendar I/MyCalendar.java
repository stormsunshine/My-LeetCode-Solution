class MyCalendar {
    List<int[]> bookingList;
    int size;

    public MyCalendar() {
        bookingList = new ArrayList<int[]>();
        size = 0;
    }
    
    public boolean book(int start, int end) {
        if (start < 0 || end < 0 || start >= end)
            return false;
        int[] newBooking = {start, end};
        if (bookingList.size() == 0) {
            bookingList.add(newBooking);
            size++;
            return true;
        }
        int[] firstBooking = bookingList.get(0);
        if (end <= firstBooking[0]) {
            bookingList.add(0, newBooking);
            size++;
            return true;
        }
        int[] lastBooking = bookingList.get(size - 1);
        if (start >= lastBooking[1]) {
            bookingList.add(newBooking);
            size++;
            return true;
        }
        for (int i = 1; i < size; i++) {
            int[] booking1 = bookingList.get(i - 1);
            int[] booking2 = bookingList.get(i);
            if (start >= booking1[1] && end <= booking2[0]) {
                bookingList.add(i, newBooking);
                size++;
                return true;
            }
            if (booking1[0] < end && booking1[1] > start)
                return false;
            if (booking2[0] < end && booking2[1] > start)
                return false;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */