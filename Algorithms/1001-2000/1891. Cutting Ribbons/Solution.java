class Solution {
    public int maxLength(int[] ribbons, int k) {
        int maxRibbon = 0;
        for (int ribbon : ribbons)
            maxRibbon = Math.max(maxRibbon, ribbon);
        int low = 0, high = maxRibbon;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            int count = 0;
            for (int ribbon : ribbons)
                count += ribbon / mid;
            if (count >= k)
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }
}