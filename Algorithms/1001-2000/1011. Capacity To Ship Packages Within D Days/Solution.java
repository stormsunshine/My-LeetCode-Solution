class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int low = 0;
        for (int weight : weights) {
            sum += weight;
            low = Math.max(low, weight);
        }
        int high = sum;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int days = daysNeed(weights, mid);
            if (days > D)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public int daysNeed(int[] weights, int capacity) {
        int days = 1;
        int currentTotal = 0;
        int length = weights.length;
        for (int i = 0; i < length; i++) {
            int weight = weights[i];
            if (currentTotal + weight <= capacity)
                currentTotal += weight;
            else {
                days++;
                currentTotal = weight;
            }
        }
        return days;
    }
}