class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : sweetness) {
            sum += num;
            min = Math.min(min, num);
        }
        if (K == 0)
            return sum;
        int low = min, high = sum / (K + 1);
        int max = 0;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (canDivide(sweetness, K + 1, mid)) {
                max = Math.max(max, mid);
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return max;
    }

    public boolean canDivide(int[] sweetness, int chunks, int lowerBound) {
        int sum = 0;
        int count = 0;
        int length = sweetness.length;
        for (int i = 0; i < length; i++) {
            int num = sweetness[i];
            sum += num;
            if (sum >= lowerBound) {
                count++;
                if (count == chunks)
                    break;
                sum = 0;
            }
        }
        return count >= chunks;
    }
}