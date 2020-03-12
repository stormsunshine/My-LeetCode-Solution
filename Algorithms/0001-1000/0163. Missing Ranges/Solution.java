class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> missingRanges = new ArrayList<String>();
        int length = nums.length;
        if (length == 0) {
            if (lower == upper)
                missingRanges.add(String.valueOf(lower));
            else
                missingRanges.add(lower + "->" + upper);
        } else {
            if ((long) nums[0] - lower == 1)
                missingRanges.add(String.valueOf(lower));
            else if ((long) nums[0] - lower >= 2) {
                long start = lower, end = nums[0] - 1;
                String missingRange = start + "->" + end;
                missingRanges.add(missingRange);
            }
            long prev = nums[0], last = upper;
            for (int i = 1; i < length; i++) {
                long num = nums[i];
                if (num <= lower)
                    continue;
                if (num - prev == 2) {
                    long missing = num - 1;
                    missingRanges.add(String.valueOf(missing));
                } else if (num - prev >= 3) {
                    long start = prev + 1, end = num - 1;
                    String missingRange = start + "->" + end;
                    missingRanges.add(missingRange);
                }
                prev = num;
            }
            if (upper - prev == 1)
                missingRanges.add(String.valueOf(upper));
            else if (upper - prev >= 2) {
                long start = prev + 1, end = upper;
                String missingRange = start + "->" + end;
                missingRanges.add(missingRange);
            }
        }
        return missingRanges;
    }
}