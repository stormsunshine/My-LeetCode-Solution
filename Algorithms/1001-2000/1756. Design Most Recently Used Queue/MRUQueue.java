class MRUQueue {
    int size;
    int[] queue;

    public MRUQueue(int n) {
        size = n;
        queue = new int[n];
        for (int i = 0; i < n; i++)
            queue[i] = i + 1;
    }
    
    public int fetch(int k) {
        int num = queue[k - 1];
        for (int i = k; i < size; i++)
            queue[i - 1] = queue[i];
        queue[size - 1] = num;
        return num;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */