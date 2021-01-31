class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] adjacentPair : adjacentPairs) {
            int num1 = adjacentPair[0], num2 = adjacentPair[1];
            List<Integer> list1 = map.getOrDefault(num1, new ArrayList<Integer>());
            List<Integer> list2 = map.getOrDefault(num2, new ArrayList<Integer>());
            list1.add(num2);
            list2.add(num1);
            map.put(num1, list1);
            map.put(num2, list2);
        }
        int length = adjacentPairs.length + 1;
        int[] nums = new int[length];
        boolean flag = false;
        Set<Integer> set = map.keySet();
        for (int num : set) {
            List<Integer> list = map.get(num);
            if (list.size() == 1) {
                if (!flag) {
                    nums[0] = num;
                    nums[1] = list.get(0);
                    flag = true;
                } else {
                    nums[length - 1] = num;
                    nums[length - 2] = list.get(0);
                }
            }
        }
        for (int i = 1; i < length - 1; i++) {
            int num = nums[i];
            List<Integer> list = map.get(num);
            for (int adjacent : list) {
                if (adjacent != nums[i - 1]) {
                    nums[i + 1] = adjacent;
                    break;
                }
            }
        }
        return nums;
    }
}