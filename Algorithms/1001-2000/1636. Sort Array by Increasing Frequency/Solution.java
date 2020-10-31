class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums)
            list.add(num);
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                int count1 = map.get(num1), count2 = map.get(num2);
                if (count1 != count2)
                    return count1 - count2;
                else
                    return num2 - num1;
            }
        });
        int length = nums.length;
        int[] sorted = new int[length];
        for (int i = 0; i < length; i++)
            sorted[i] = list.get(i);
        return sorted;
    }
}