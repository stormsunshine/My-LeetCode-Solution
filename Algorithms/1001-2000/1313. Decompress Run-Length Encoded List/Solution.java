class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i += 2) {
            int count = nums[i];
            int value = nums[i + 1];
            for (int j = 0; j < count; j++)
                list.add(value);
        }
        int size = list.size();
        int[] decompressed = new int[size];
        for (int i = 0; i < size; i++)
            decompressed[i] = list.get(i);
        return decompressed;
    }
}