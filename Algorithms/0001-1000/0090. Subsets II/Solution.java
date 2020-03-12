class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> countsMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int count = countsMap.getOrDefault(num, 0);
            count++;
            countsMap.put(num, count);
        }
        int length = nums.length;
        List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
        List<String> powerStrSet = new ArrayList<String>();
        List<Integer> emptySet = new ArrayList<Integer>();
        powerSet.add(emptySet);
        powerStrSet.add(emptySet.toString());
        List<Integer> set = new ArrayList<Integer>();
        for (int num : nums)
            set.add(num);
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        queue.offer(emptySet);
        while (!queue.isEmpty()) {
            List<Integer> prevSubset = queue.poll();
            int lastIndex = -1;
            if (!prevSubset.isEmpty()) {
                int lastNum = prevSubset.get(prevSubset.size() - 1);
                lastIndex = set.indexOf(lastNum);
            }
            for (int i = lastIndex + 1; i < length; i++) {
                List<Integer> curSubset = new ArrayList<Integer>();
                for (int num : prevSubset)
                    curSubset.add(num);
                curSubset.add(nums[i]);
                boolean flag = true;
                Map<Integer, Integer> curCountsMap = new HashMap<Integer, Integer>();
                for (int num : curSubset) {
                    int count = curCountsMap.getOrDefault(num, 0);
                    count++;
                    int maxCount = countsMap.getOrDefault(num, 0);
                    if (count > maxCount) {
                        flag = false;
                        break;
                    }
                    curCountsMap.put(num, count);
                }
                if (flag && !powerStrSet.contains(curSubset.toString())) {
                    powerSet.add(curSubset);
                    powerStrSet.add(curSubset.toString());
                    queue.offer(curSubset);
                }
            }
        }
        return powerSet;
    }
}