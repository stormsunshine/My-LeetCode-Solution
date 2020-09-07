class SparseVector {
    Map<Integer, Integer> map;
    
    SparseVector(int[] nums) {
        map = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0)
                map.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if (this.map.size() > vec.map.size())
            return vec.dotProduct(this);
        int product = 0;
        Map<Integer, Integer> map2 = vec.map;
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            int index = entry.getKey(), num = entry.getValue();
            if (map2.containsKey(index))
                product += num * map2.get(index);
        }
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);