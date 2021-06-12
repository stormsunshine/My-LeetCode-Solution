class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Set<Integer> set = new HashSet<Integer>();
        for (int[] range : ranges) {
            int start = Math.max(range[0], left);
            int end = Math.min(range[1], right);
            for (int i = start; i <= end; i++)
                set.add(i);
        }
        return set.size() == right - left + 1;
    }
}