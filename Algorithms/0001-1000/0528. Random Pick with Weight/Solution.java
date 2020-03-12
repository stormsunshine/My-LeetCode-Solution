class Solution {
    int[] accumulatedWeights;
    int totalWeight;

    public Solution(int[] w) {
        int length = w.length;
        accumulatedWeights = new int[length];
        accumulatedWeights[0] = w[0];
        for (int i = 1; i < length; i++)
            accumulatedWeights[i] = accumulatedWeights[i - 1] + w[i];
        totalWeight = accumulatedWeights[length - 1];
    }
    
    public int pickIndex() {
        int random = (int) (Math.random() * totalWeight);
        int index = binarySearch(random);
        return index;
    }

    private int binarySearch(int target) {
        int low = 0, high = accumulatedWeights.length;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int curWeight = accumulatedWeights[mid];
            if (curWeight == target)
                return mid + 1;
            else if (curWeight > target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */