class Solution {
    public int maxEqualFreq(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxLength = 1;
        Map<Integer, Integer> numFrequencyMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> frequencyCountMap = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int frequency = numFrequencyMap.getOrDefault(num, 0);
            int newFrequency = frequency + 1;
            numFrequencyMap.put(num, newFrequency);
            if (frequency > 0) {
                int count = frequencyCountMap.get(frequency) - 1;
                if (count > 0)
                    frequencyCountMap.put(frequency, count);
                else
                    frequencyCountMap.remove(frequency);
            }
            int newCount = frequencyCountMap.getOrDefault(newFrequency, 0) + 1;
            frequencyCountMap.put(newFrequency, newCount);
            if (isPossible(frequencyCountMap))
                maxLength = i + 1;
        }
        return maxLength;
    }

    public boolean isPossible(Map<Integer, Integer> frequencyCountMap) {
        if (frequencyCountMap.size() > 2)
            return false;
        List<Integer> list = new ArrayList<Integer>(frequencyCountMap.keySet());
        if (list.size() == 1) {
            int key = list.get(0);
            if (key == 1)
                return true;
            int count = frequencyCountMap.get(key);
            return count == 1;
        } else {
            int min = list.get(0), max = list.get(1);
            if (min > max) {
                int temp = min;
                min = max;
                max = temp;
            }
            if (max - min == 1 && frequencyCountMap.get(max) == 1)
                return true;
            else if (min == 1 && frequencyCountMap.get(min) == 1)
                return true;
            else
                return false;
        }
    }
}