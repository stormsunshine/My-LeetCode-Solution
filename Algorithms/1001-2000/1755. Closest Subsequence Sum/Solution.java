class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        if (goal == 0)
            return 0;
        Arrays.sort(nums);
        int length = nums.length;
        int halfLength = length / 2;
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(0);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(0);
        for (int i = 0; i < halfLength; i++) {
            int num = nums[i];
            int size = list1.size();
            for (int j = 0; j < size; j++)
                list1.add(list1.get(j) + num);
        }
        for (int i = halfLength; i < length; i++) {
            int num = nums[i];
            int size = list2.size();
            for (int j = 0; j < size; j++)
                list2.add(list2.get(j) + num);
        }
        Collections.sort(list1);
        Collections.sort(list2);
        int minDifference = Integer.MAX_VALUE;
        int size1 = list1.size(), size2 = list2.size();
        int pointer1 = 0, pointer2 = size2 - 1;
        while (pointer1 < size1 && pointer2 >= 0) {
            int curSum = list1.get(pointer1) + list2.get(pointer2);
            int curDifference = curSum - goal;
            minDifference = Math.min(minDifference, Math.abs(curDifference));
            if (curDifference == 0)
                return 0;
            else if (curDifference < 0)
                pointer1++;
            else
                pointer2--;
        }
        return minDifference;
    }
}