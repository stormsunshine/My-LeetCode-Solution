class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> numberCountMap = new HashMap<Integer, Integer>();
        for (int num : arr) {
            int count = numberCountMap.getOrDefault(num, 0);
            count++;
            numberCountMap.put(num, count);
        }
        Map<Integer, Integer> countNumbersMap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            public int compare(Integer key1, Integer key2) {
                return key2 - key1;
            }
        });
        Set<Integer> numberSet = numberCountMap.keySet();
        for (int num : numberSet) {
            int count = numberCountMap.getOrDefault(num, 0);
            int nums = countNumbersMap.getOrDefault(count, 0);
            nums++;
            countNumbersMap.put(count, nums);
        }
        int halfLength = arr.length / 2;
        Iterator<Integer> iterator = countNumbersMap.keySet().iterator();
        int size = 0;
        int removeCount = 0;
        while (iterator.hasNext() && removeCount < halfLength) {
            int count = iterator.next();
            int nums = countNumbersMap.getOrDefault(count, 0);
            for (int i = 0; i < nums; i++) {
                removeCount += count;
                size++;
                if (removeCount >= halfLength)
                    return size;
            }
        }
        return size;
    }
}