class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<String>();
        if (nums.length == 0)
            return ranges;
        long start = nums[0], prev = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            long cur = nums[i];
            if (cur - prev > 1) {
                if (start == prev)
                    ranges.add(String.valueOf(start));
                else
                    ranges.add(start + "->" + prev);
                start = cur;
            }
            prev = cur;
        }
        long last = nums[length - 1];
        if (start == last)
            ranges.add(String.valueOf(start));
        else
            ranges.add(start + "->" + last);
        return ranges;
    }
}