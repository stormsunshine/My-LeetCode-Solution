class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        if (length == 0 || citations[length - 1] == 0)
            return 0;
        int low = 0, high = length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (citations[mid] < length - mid)
                low = mid + 1;
            else
                high = mid;
        }
        return length - low;
    }
}