class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
		int low = 0, high = nums.length - 1;
		int index = -1;
		while (low <= high) {
			int mid = (high - low) / 2 + low;
			int num = nums[mid];
			if (num > target)
				high = mid - 1;
			else if (num < target)
				low = mid + 1;
			else {
				index = mid;
				break;
			}
		}
		if (low <= high) {
			int tempHigh = index, tempLow = index;
			while (low < tempHigh) {
				int mid = (tempHigh - low) / 2 + low;
				int num = nums[mid];
				if (num < target)
					low = mid + 1;
				else
					tempHigh = mid;
			}
			first = low;
			while (tempLow < high) {
				int mid = (high + 1 - tempLow) / 2 + tempLow;
				int num = nums[mid];
				if (num > target)
					high = mid - 1;
				else
					tempLow = mid;
			}
			last = tempLow;
		}
		int[] res = { first, last };
		return res;
    }
}