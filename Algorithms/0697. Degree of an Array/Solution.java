class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        int maxFrequency = 0;
        for (int num : nums) {
            int frequency = frequencyMap.getOrDefault(num, 0);
            frequency++;
            maxFrequency = Math.max(maxFrequency, frequency);
            frequencyMap.put(num, frequency);
        }
        Set<Integer> maxFrequencySet = new HashSet<Integer>();
        Set<Integer> keySet = frequencyMap.keySet();
        for (int num : keySet) {
            int frequency = frequencyMap.getOrDefault(num, 0);
            if (frequency == maxFrequency)
                maxFrequencySet.add(num);
        }
        Map<Integer, List<Integer>> numIndicesMap = new HashMap<Integer, List<Integer>>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (maxFrequencySet.contains(num)) {
                List<Integer> indices = numIndicesMap.getOrDefault(num, new ArrayList<Integer>());
                indices.add(i);
                numIndicesMap.put(num, indices);
            }
        }
        int minLength = length;
        for (int num : maxFrequencySet) {
            List<Integer> indices = numIndicesMap.getOrDefault(num, new ArrayList<Integer>());
            int size = indices.size();
            if (size > 0) {
                int minIndex = indices.get(0), maxIndex = indices.get(size - 1);
                minLength = Math.min(minLength, maxIndex - minIndex + 1);
            }
        }
        return minLength;
    }
}