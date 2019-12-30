class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int length = nums.length;
        if (length % k != 0)
            return false;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums)
            list.add(num);
        while (!list.isEmpty()) {
            int min = list.remove(0);
            for (int i = min + 1; i <= min + k - 1; i++) {
                if (!list.contains(i))
                    return false;
                list.remove(new Integer(i));
            }
        }
        return true;
    }
}