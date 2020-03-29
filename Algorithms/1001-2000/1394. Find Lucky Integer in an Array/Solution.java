class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : arr) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int luckyNumber = -1;
        Set<Integer> keySet = map.keySet();
        for (int num : keySet) {
            int count = map.get(num);
            if (count == num)
                luckyNumber = Math.max(luckyNumber, num);
        }
        return luckyNumber;
    }
}