class MyCircularQueue {
    int[] queueArray;
    int capacity;
    int start;
    int end;
    int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queueArray = new int[k];
        Arrays.fill(queueArray, -1);
        capacity = k;
        start = 0;
        end = 0;
        size = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        if (size == 0) {
            start = 0;
            end = 0;
        } else
            end = (end + 1) % capacity;
        queueArray[end] = value;
        size++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        queueArray[start] = -1;
        start = (start + 1) % capacity;
        size--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return queueArray[start];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return queueArray[end];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */