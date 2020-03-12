class Solution {
    public int maxSumDivThree(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int sum = 0;
        List<Integer> ones = new ArrayList<Integer>();
        List<Integer> twos = new ArrayList<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            sum += num;
            if (num % 3 == 1)
                ones.add(num);
            else if (num % 3 == 2)
                twos.add(num);
        }
        if (sum % 3 == 0)
            return sum;
        int onesSize = ones.size(), twosSize = twos.size();
        if (sum % 3 == 1) {
            if (onesSize >= 1 && twosSize >= 2) {
                int min = Math.min(ones.get(0), twos.get(0) + twos.get(1));
                int greatestSum = sum - min;
                return greatestSum;
            } else if (onesSize >= 1) {
                int greatestSum = sum - ones.get(0);
                return greatestSum;
            } else if (twosSize >= 2) {
                int greatestSum = sum - twos.get(0) - twos.get(1);
                return greatestSum;
            } else
                return 0;
        } else {
            if (onesSize >= 2 && twosSize >= 1) {
                int min = Math.min(ones.get(0) + ones.get(1), twos.get(0));
                int greatestSum = sum - min;
                return greatestSum;
            } else if (onesSize >= 2) {
                int greatestSum = sum - ones.get(0) - ones.get(1);
                return greatestSum;
            } else if (twosSize >= 1) {
                int greatestSum = sum - twos.get(0);
                return greatestSum;
            } else
                return 0;
        }
    }
}