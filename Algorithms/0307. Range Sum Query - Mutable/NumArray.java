class NumArray {
    int[] segmentTree;
    int length;

    public NumArray(int[] nums) {
        length = nums.length;
        segmentTree = new int[length * 2];
        for (int i = 0; i < length; i++)
            segmentTree[i + length] = nums[i];
        for (int i = length - 1; i > 0; i--)
            segmentTree[i] = segmentTree[i * 2] + segmentTree[i * 2 + 1];
    }
    
    public void update(int i, int val) {
        int index = i + length;
        int prevVal = segmentTree[index];
        int difference = val - prevVal;
        while (index > 0) {
            segmentTree[index] += difference;
            index /= 2;
        }
    }
    
    public int sumRange(int i, int j) {
        int left = i + length, right = j + length;
        int sum = 0;
        while (left <= right) {
            if (left % 2 == 1) {
               sum += segmentTree[left];
               left++;
            }
            if (right % 2 == 0) {
               sum += segmentTree[right];
               right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */