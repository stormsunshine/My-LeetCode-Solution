class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int length = arr.length;
        int[] prefixSums = new int[length];
        prefixSums[0] = arr[0];
        for (int i = 1; i < length; i++)
            prefixSums[i] = prefixSums[i - 1] + arr[i];
        for (int i = 0; i < length; i++)
            sum += arr[i];
        for (int i = 2; i < length; i++) {
            for (int j = i - 3; j >= 0; j -= 2)
                sum += prefixSums[i] - prefixSums[j];
            if (i % 2 == 0)
                sum += prefixSums[i];
        }
        return sum;
    }
}