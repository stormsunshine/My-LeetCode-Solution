class MedianFinder {
    PriorityQueue<Integer> priorityQueue1;
    PriorityQueue<Integer> priorityQueue2;
    boolean even;

    /** initialize your data structure here. */
    public MedianFinder() {
        priorityQueue1 = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        priorityQueue2 = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num1 - num2;
            }
        });
        even = true;
    }
    
    public void addNum(int num) {
        if (even) {
            priorityQueue2.offer(num);
            priorityQueue1.offer(priorityQueue2.poll());
        } else {
            priorityQueue1.offer(num);
            priorityQueue2.offer(priorityQueue1.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if (even)
            return (priorityQueue1.peek() + priorityQueue2.peek()) / 2.0;
        else
            return priorityQueue1.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */