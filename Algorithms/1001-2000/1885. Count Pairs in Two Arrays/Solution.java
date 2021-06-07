class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        long count = 0;
        int n = nums1.length;
        int[] differences = new int[n];
        for (int i = 0; i < n; i++)
            differences[i] = nums1[i] - nums2[i];
        Arrays.sort(differences);
        for (int i = 0; i < n - 1; i++) {
            int target = -differences[i] + 1;
            int index = binarySearch(differences, n, target, i + 1);
            count += n - index;
        }
        return count;
    }

    public int binarySearch(int[] differences, int n, int target, int startIndex) {
        int low = startIndex, high = n - 1;
        if (differences[high] < target)
            return n;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (differences[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}