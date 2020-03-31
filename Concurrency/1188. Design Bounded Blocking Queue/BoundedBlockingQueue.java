class BoundedBlockingQueue {
    int capacity;
    Queue<Integer> queue;
    private Semaphore semaphoreEnqueue;
    private Semaphore semaphoreDequeue;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<Integer>();
        semaphoreEnqueue = new Semaphore(capacity);
        semaphoreDequeue = new Semaphore(0);
    }
    
    public void enqueue(int element) throws InterruptedException {
        semaphoreEnqueue.acquire();
        queue.offer(element);
        semaphoreDequeue.release();
    }
    
    public int dequeue() throws InterruptedException {
        semaphoreDequeue.acquire();
        int element = queue.poll();
        semaphoreEnqueue.release();
        return element;
    }
    
    public int size() {
        return queue.size();
    }
}