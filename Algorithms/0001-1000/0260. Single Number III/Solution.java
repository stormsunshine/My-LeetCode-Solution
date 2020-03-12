public class Solution {
    public int[] singleNumber(int[] nums) {
		int[] singles = new int[2];
		int result = nums[0];
		for (int i = 1; i < nums.length; i++)
			result = result ^ nums[i];
		singles[0] = 0;
		singles[1] = 0;
		int n = result & (~(result - 1));
		for (int i = 0; i < nums.length; i++) {
			if ((n & nums[i]) != 0)
				singles[0] = singles[0] ^ nums[i];
			else
				singles[1] = singles[1] ^ nums[i];
		}
		return singles;
	}
}