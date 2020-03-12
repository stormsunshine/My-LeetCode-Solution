class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        List<Integer> ones = new ArrayList<Integer>();
        List<Integer> zeros = new ArrayList<Integer>();
        if (nums[0] == 0)
            ones.add(0);
        int count = 0;
        int prev = -1;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (prev < 0)
                count = 1;
            else {
                if (num == prev)
                    count++;
                else {
                    if (prev == 1)
                        ones.add(count);
                    else
                        zeros.add(count);
                    count = 1;
                }
            }
            prev = num;
        }
        if (count > 0) {
            if (prev == 1)
                ones.add(count);
            else
                zeros.add(count);
        }
        int max = 0;
        for (int num : ones)
            max = Math.max(max, num);
        int onesSize = ones.size(), zerosSize = zeros.size();
        for (int i = 0; i < zerosSize; i++) {
            int curZeros = zeros.get(i);
            if (i == onesSize - 1) {
                int prevOnes = ones.get(i);
                max = Math.max(max, prevOnes + 1);
            } else {
                int prevOnes = ones.get(i), nextOnes = ones.get(i + 1);
                if (curZeros == 1)
                    max = Math.max(max, prevOnes + nextOnes + 1);
                else
                    max = Math.max(max, Math.max(prevOnes + 1, nextOnes + 1));
            }
        }
        return max;
    }
}