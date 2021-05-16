class FindSumPairs {
    int[] nums2;
    Map<Integer, Integer> map1;
    Map<Integer, Integer> map2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums2 = nums2;
        map1 = new HashMap<Integer, Integer>();
        map2 = new HashMap<Integer, Integer>();
        for (int num : nums1)
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        for (int num : nums2)
            map2.put(num, map2.getOrDefault(num, 0) + 1);
    }
    
    public void add(int index, int val) {
        int prev = nums2[index], curr = nums2[index] + val;
        int count1 = map2.get(prev) - 1, count2 = map2.getOrDefault(curr, 0) + 1;
        if (count1 > 0)
            map2.put(prev, count1);
        else
            map2.remove(prev);
        map2.put(curr, count2);
        nums2[index] = curr;
    }
    
    public int count(int tot) {
        int totalCount = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int num = entry.getKey(), count1 = entry.getValue();
            int count2 = map2.getOrDefault(tot - num, 0);
            totalCount += count1 * count2;
        }
        return totalCount;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */