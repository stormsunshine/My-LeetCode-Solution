class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<Integer, Integer>();
        for (int num : arr) {
            int count = numCountMap.getOrDefault(num, 0) + 1;
            numCountMap.put(num, count);
        }
        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> numSet = numCountMap.keySet();
        for (int num : numSet)
            list.add(numCountMap.get(num));
        int unique = 0;
        Collections.sort(list);
        int remain = arr.length - k;
        for (int i = list.size() - 1; i >= 0 && remain > 0; i--) {
            int count = list.get(i);
            remain -= count;
            unique++;
        }
        return unique;
    }
}