class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int minSum1 = length1, maxSum1 = 6 * length1, minSum2 = length2, maxSum2 = 6 * length2;
        if (minSum1 > maxSum2 || maxSum1 < minSum2)
            return -1;
        int sum1 = 0, sum2 = 0;
        int[] counts1 = new int[7];
        int[] counts2 = new int[7];
        for (int i = 0; i < length1; i++) {
            sum1 += nums1[i];
            counts1[nums1[i]]++;
        }
        for (int i = 0; i < length2; i++) {
            sum2 += nums2[i];
            counts2[nums2[i]]++;
        }
        if (sum1 == sum2)
            return 0;
        else if (sum1 < sum2)
            return getOperations(counts1, counts2, sum2 - sum1);
        else
            return getOperations(counts2, counts1, sum1 - sum2);
    }

    public int getOperations(int[] minCounts, int[] maxCounts, int difference) {
        int[] differences = new int[6];
        for (int i = 1; i < 6; i++)
            differences[6 - i] += minCounts[i];
        for (int j = 6; j > 1; j--)
            differences[j - 1] += maxCounts[j];
        int operations = 0;
        for (int i = 5; i > 0 && difference > 0; i--) {
            int count = differences[i];
            int maxReduce = i * count;
            if (maxReduce < difference) {
                difference -= maxReduce;
                operations += count;
            } else {
                int curOperations = difference / i;
                if (difference % i != 0)
                    curOperations++;
                operations += curOperations;
                difference = 0;
            }
        }
        return operations;
    }
}