class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        int sum = 0;
        for (int num : quantity)
            sum += num;
        if (sum > nums.length)
            return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        Arrays.sort(quantity);
        return backtrack(map, quantity, quantity.length - 1);
    }

    public boolean backtrack(Map<Integer, Integer> map, int[] quantity, int index) {
        if (index == -1)
            return true;
        boolean flag = false;
        int curQuantity = quantity[index];
        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            int value = map.get(key);
            if (value >= curQuantity) {
                map.put(key, value - curQuantity);
                flag = backtrack(map, quantity, index - 1);
                if (flag)
                    break;
                else
                    map.put(key, value);
            }
        }
        return flag;
    }
}