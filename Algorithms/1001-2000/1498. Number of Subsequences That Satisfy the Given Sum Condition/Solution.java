class Solution {
    public int numSubseq(int[] nums, int target) {
        final int MODULO = 1000000007;
        int length = nums.length;
        Integer[] indices = new Integer[length];
        for (int i = 0; i < length; i++)
            indices[i] = i;
        Arrays.sort(indices, new Comparator<Integer>() {
            public int compare(Integer index1, Integer index2) {
                if (nums[index1] != nums[index2])
                    return nums[index1] - nums[index2];
                else
                    return index1 - index2;
            }
        });
        int[] power2 = new int[length + 1];
        power2[0] = 1;
        for (int i = 1; i <= length; i++)
            power2[i] = (power2[i - 1] * 2) % MODULO;
        int count = 0;
        int pointer = length - 1;
        for (int i = 0; i < length; i++) {
            pointer = Math.max(pointer, i);
            while (pointer > i && nums[indices[pointer]] + nums[indices[i]] > target)
                pointer--;
            if (nums[indices[pointer]] + nums[indices[i]] <= target) {
                int subLength = pointer - i;
                count = (count + power2[subLength]) % MODULO;
            }
        }
        return count;
    }
}