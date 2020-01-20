class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0 || nums == null || nums.length == 0)
            return 0;
        if (k == 0) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                int num = nums[i];
                int count = map.getOrDefault(num, 0);
                count++;
                map.put(num, count);
            }
            int pairs = 0;
            Set<Integer> set = map.keySet();
            for (int num : set) {
                int count = map.get(num);
                if (count > 1)
                    pairs++;
            }
            return pairs;
        } else {
            List<Integer> list = new ArrayList<Integer>();
            for (int num : nums)
                list.add(num);
            Collections.sort(list);
            int pairs = 0;
            int length = list.size();
            int max = list.get(length - 1);
            for (int i = 0; i < length; i++) {
                int num = list.get(i);
                if (i > 0 && list.get(i - 1) == num)
                    continue;
                int nextNum = num + k;
                if (nextNum > max)
                    break;
                if (list.contains(nextNum))
                    pairs++;
            }
            return pairs;
        }
    }
}