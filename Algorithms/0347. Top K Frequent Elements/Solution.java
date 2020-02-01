class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberCountMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int count = numberCountMap.getOrDefault(num, 0);
            count++;
            numberCountMap.put(num, count);
        }
        Map<Integer, List<Integer>> countNumbersMap = new TreeMap<Integer, List<Integer>>(new Comparator<Integer>() {
            public int compare(Integer count1, Integer count2) {
                return count2 - count1;
            }
        });
        Set<Integer> numSet = numberCountMap.keySet();
        for (int num : numSet) {
            int count = numberCountMap.getOrDefault(num, 0);
            if (count > 0) {
                List<Integer> numList = countNumbersMap.getOrDefault(count, new ArrayList<Integer>());
                numList.add(num);
                countNumbersMap.put(count, numList);
            }
        }
        List<Integer> topKFrequentList = new ArrayList<Integer>();
        Set<Integer> countSet = countNumbersMap.keySet();
        Iterator<Integer> iterator = countSet.iterator();
        int elementsCount = 0;
        while (iterator.hasNext() && elementsCount < k) {
            int count = iterator.next();
            List<Integer> numsList = countNumbersMap.getOrDefault(count, new ArrayList<Integer>());
            for (int num : numsList) {
                topKFrequentList.add(num);
                elementsCount++;
            }
        }
        return topKFrequentList;
    }
}