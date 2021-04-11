class MKAverage {
    int m;
    int k;
    Queue<Integer> queue;
    TreeMap<Integer, Integer> left;
    TreeMap<Integer, Integer> mid;
    TreeMap<Integer, Integer> right;
    int leftSize, midSize, rightSize;
    long sum;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        queue = new LinkedList<Integer>();
        left = new TreeMap<Integer, Integer>();
        mid = new TreeMap<Integer, Integer>();
        right = new TreeMap<Integer, Integer>();
    }

    public void addElement(int num) {
        if (queue.size() == m) {
            int remove = queue.poll();
            if (left.containsKey(remove)) {
                left.put(remove, left.get(remove) - 1);
                if (left.get(remove) == 0)
                    left.remove(remove);
                leftSize--;
            } else if (mid.containsKey(remove)) {
                mid.put(remove, mid.get(remove) - 1);
                if (mid.get(remove) == 0)
                    mid.remove(remove);
                midSize--;
                sum -= remove;
            } else {
                right.put(remove, right.get(remove) - 1);
                if (right.get(remove) == 0)
                    right.remove(remove);
                rightSize--;
            }
            while (midSize > 0 && leftSize < k) {
                int first = mid.firstKey();
                left.put(first, left.getOrDefault(first, 0) + 1);
                mid.put(first, mid.get(first) - 1);
                if (mid.get(first) == 0)
                    mid.remove(first);
                leftSize++;
                midSize--;
                sum -= first;
            }
            while (rightSize > 0 && midSize < m - 2 * k) {
                int first = right.firstKey();
                mid.put(first, mid.getOrDefault(first, 0) + 1);
                right.put(first, right.get(first) - 1);
                if (right.get(first) == 0)
                    right.remove(first);
                midSize++;
                rightSize--;
                sum += first;
            }
        }
        queue.offer(num);
        if (leftSize < k || num <= left.lastKey()) {
            left.put(num, left.getOrDefault(num, 0) + 1);
            leftSize++;
        } else if (midSize < m - 2 * k || num <= mid.lastKey()) {
            mid.put(num, mid.getOrDefault(num, 0) + 1);
            midSize++;
            sum += num;
        } else {
            right.put(num, right.getOrDefault(num, 0) + 1);
            rightSize++;
        }
        while (leftSize > k) {
            int last = left.lastKey();
            left.put(last, left.get(last) - 1);
            if (left.get(last) == 0)
                left.remove(last);
            mid.put(last, mid.getOrDefault(last, 0) + 1);
            leftSize--;
            midSize++;
            sum += last;
        }
        while (midSize > m - 2 * k) {
            int last = mid.lastKey();
            mid.put(last, mid.get(last) - 1);
            if (mid.get(last) == 0)
                mid.remove(last);
            right.put(last, right.getOrDefault(last, 0) + 1);
            midSize--;
            rightSize++;
            sum -= last;
        }
    }

    public int calculateMKAverage() {
        return queue.size() < m ? -1 : (int) (sum / (m - 2 * k));
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */