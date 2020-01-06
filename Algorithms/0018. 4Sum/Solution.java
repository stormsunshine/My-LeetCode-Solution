class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        int length = nums.length;
        int left1Start = 0, left1End = length - 4, left2End = length - 3;
        for (int left1 = left1Start; left1 <= left1End; left1++) {
            int left1Num = nums[left1];
            if (left1 > 0 && left1Num == nums[left1 - 1])
                continue;
            for (int left2 = left1 + 1; left2 <= left2End; left2++) {
                int left2Num = nums[left2];
                if (left2 - 1 > left1 && left2Num == nums[left2 - 1])
                    continue;
                int mid = left2 + 1, right = length - 1;
                while (mid < right) {
                    int midNum = nums[mid], rightNum = nums[right];
                    int sum = left1Num + left2Num + midNum + rightNum;
                    if (sum == target) {
                        List<Integer> quadruplet = new ArrayList<Integer>();
                        quadruplet.add(left1Num);
                        quadruplet.add(left2Num);
                        quadruplet.add(midNum);
                        quadruplet.add(rightNum);
                        quadruplets.add(quadruplet);
                        while (mid < right && nums[mid] == nums[mid + 1])
                            mid++;
                        while (mid < right && nums[right] == nums[right - 1])
                            right--;
                        mid++;
                        right--;
                    } else if (sum < target)
                        mid++;
                    else
                        right--;
                }
            }
        }
        return quadruplets;
    }
}