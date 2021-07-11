class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] concat = new int[n * 2];
        for (int i = 0; i < n; i++) {
            concat[i] = nums[i];
            concat[i + n] = nums[i];
        }
        return concat;
    }
}