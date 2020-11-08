class Solution {
    final static int MODULO = 1000000007;
    final static int MAX = 100000;
    int[] segmentTree = new int[MAX * 2 + 1];

    public int createSortedArray(int[] instructions) {
        int cost = 0;
        int length = instructions.length;
        for (int i = 0; i < length; i++) {
            int num = instructions[i];
            int count = segmentTree[num + MAX] + 1;
            update(num, count);
            int sumRange1 = sumRange(1, num - 1), sumRange2 = sumRange(num + 1, MAX);
            cost = (cost + Math.min(sumRange1, sumRange2)) % MODULO;
        }
        return cost;
    }
    
    public void update(int i, int val) {
        int index = i + MAX;
        int prevVal = segmentTree[index];
        int difference = val - prevVal;
        while (index > 0) {
            segmentTree[index] = (segmentTree[index] + difference) % MODULO;
            index >>= 1;
        }
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        int index1 = i + MAX, index2 = j + MAX;
        while (index1 <= index2) {
            if (index1 % 2 == 1) {
                sum = (sum + segmentTree[index1]) % MODULO;
                index1++;
            }
            if (index2 % 2 == 0) {
                sum = (sum + segmentTree[index2]) % MODULO;
                index2--;
            }
            index1 >>= 1;
            index2 >>= 1;
        }
        return sum;
    }
}