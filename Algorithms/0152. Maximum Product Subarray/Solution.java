public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int maxProduct = nums[0];  
        int maxTemp = nums[0];  
        int minTemp = nums[0];
        for (int i = 1; i < length; i++) {
            int product1 = nums[i] * maxTemp;
            int product2 = nums[i] * minTemp;
            maxTemp = Math.max(Math.max(product1, product2), nums[i]);
            minTemp = Math.min(Math.min(product1, product2), nums[i]);
            maxProduct = Math.max(maxProduct, maxTemp);
        }
        return maxProduct;  
    }
}