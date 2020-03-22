class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++)
            list.add(index[i], nums[i]);
        int[] target = new int[length];
        for (int i = 0; i < length; i++)
            target[i] = list.get(i);
        return target;
    }
}