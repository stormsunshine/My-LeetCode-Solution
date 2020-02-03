class MyCircularDeque {
    int[] dequeArray;
    int capacity;
    int start;
    int end;
    int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        dequeArray = new int[k];
        Arrays.fill(dequeArray, -1);
        capacity = k;
        start = 0;
        end = 0;
        size = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull())
            return false;
        if (size == 0) {
            start = 0;
            end = 0;
        } else
            start = (start - 1 + capacity) % capacity;
        dequeArray[start] = value;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull())
            return false;
        if (size == 0) {
            start = 0;
            end = 0;
        } else
            end = (end + 1) % capacity;
        dequeArray[end] = value;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty())
            return false;
        dequeArray[start] = -1;
        start = (start + 1) % capacity;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        dequeArray[end] = -1;
        end = (end - 1 + capacity) % capacity;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return dequeArray[start];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return dequeArray[end];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */