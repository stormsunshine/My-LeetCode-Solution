class Solution {
    public int arraySign(int[] nums) {
        int negativeCount = 0;
        for (int num : nums) {
            if (num < 0)
                negativeCount++;
            else if (num == 0)
                return 0;
        }
        return negativeCount % 2 == 0 ? 1 : -1;
    }
}