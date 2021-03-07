class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums)
            sum += (long) num;
        long difference = (long) goal - sum;
        if (difference == 0)
            return 0;
        else {
            difference = Math.abs(difference);
            long minAdd = difference / limit;
            if (difference % limit != 0)
                minAdd++;
            return (int) minAdd;
        }
    }
}