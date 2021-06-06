class Solution {
    public int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int operations = 0;
        while (map.size() > 1) {
            int largest = map.lastKey();
            int nextLargest = map.floorKey(largest - 1);
            int curOperations = map.get(largest);
            operations += curOperations;
            map.remove(largest);
            map.put(nextLargest, map.get(nextLargest) + curOperations);
        }
        return operations;
    }
}