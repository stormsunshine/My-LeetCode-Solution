class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        int length = nums.length;
        int leftStart = 0, leftEnd = length - 3;
        for (int left = leftStart; left <= leftEnd; left++) {
            int leftNum = nums[left];
            if (leftNum > 0)
                break;
            if (left > 0 && leftNum == nums[left - 1])
                continue;
            int mid = left + 1, right = length - 1;
            while (mid < right) {
                int midNum = nums[mid], rightNum = nums[right];
                int sum = leftNum + midNum + rightNum;
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(leftNum);
                    triplet.add(midNum);
                    triplet.add(rightNum);
                    triplets.add(triplet);
                    while (mid < right && nums[mid] == nums[mid + 1])
                        mid++;
                    while (mid < right && nums[right] == nums[right - 1])
                        right--;
                    mid++;
                    right--;
                } else if (sum < 0)
                    mid++;
                else
                    right--;
            }
        }
        return triplets;
    }
}