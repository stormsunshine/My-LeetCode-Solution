class KthLargest {
    int[] elements;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = 0;
        elements = new int[k];
        for (int num : nums)
            insert(num);
    }

    public int add(int val) {
        insert(val);
        return elements[k - 1];
    }

    public void insert(int val) {
        if (k == 0) {
            elements[0] = val;
            k++;
        } else {
            if (k < elements.length) {
                elements[k] = val;
                k++;
            }
            if (val < elements[k - 1])
                return;
            elements[k - 1] = val;
            int insertIndex = 0;
            for (int i = k - 2; i >= 0; i--) {
                if (elements[i] > val) {
                    insertIndex = i + 1;
                    break;
                }
                elements[i + 1] = elements[i];
            }
            elements[insertIndex] = val;
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */