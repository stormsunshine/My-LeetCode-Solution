class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
        List<Integer> emptySet = new ArrayList<Integer>();
        powerSet.add(emptySet);
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
                powerSet.add(curSubset);
                queue.offer(curSubset);
            }
        }
        return powerSet;
    }
}