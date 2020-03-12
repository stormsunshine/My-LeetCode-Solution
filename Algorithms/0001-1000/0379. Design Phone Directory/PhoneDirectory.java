class PhoneDirectory {
    int maxNumbers;
    boolean[] available;
    Queue<Integer> unused;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        available = new boolean[maxNumbers];
        unused = new LinkedList<Integer>();
        for (int i = 0; i < maxNumbers; i++) {
            available[i] = true;
            unused.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (unused.isEmpty())
            return -1;
        else {
            int next = unused.poll();
            available[next] = false;
            return next;
        }
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number < 0 || number >= maxNumbers)
            return false;
        else
            return available[number];
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (!available[number]) {
            unused.offer(number);
            available[number] = true;
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */