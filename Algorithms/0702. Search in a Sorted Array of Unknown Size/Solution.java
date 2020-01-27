class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target)
            return 0;
        int low = 0, high = 1;
        while (reader.get(high) < target) {
            low = high + 1;
            high <<= 1;
        }
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            int num = reader.get(mid);
            if (num == target)
                return mid;
            else if (num > target)
                high--;
            else
                low++;
        }
        return -1;
    }
}