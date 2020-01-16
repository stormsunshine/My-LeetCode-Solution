class MovingAverage {
    Queue<Integer> queue;
    double sum;
    int size;
    int capacity;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        sum = 0;
        capacity = size;
    }
    
    public double next(int val) {
        if (size < capacity) {
            queue.offer(val);
            size++;
            sum += val;
        } else {
            sum -= queue.poll();
            queue.offer(val);
            sum += val;
        }
        return sum / size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */