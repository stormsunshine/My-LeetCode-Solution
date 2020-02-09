class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sumThreshold = threshold * k;
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += arr[i];
        if (sum >= sumThreshold)
            count++;
        int length = arr.length;
        for (int i = k; i < length; i++) {
            sum -= arr[i - k];
            sum += arr[i];
            if (sum >= sumThreshold)
                count++;
        }
        return count;
    }
}