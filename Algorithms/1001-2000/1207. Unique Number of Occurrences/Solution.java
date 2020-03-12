class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : arr) {
            int count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> keySet = map.keySet();
        for (int num : keySet) {
            int count = map.getOrDefault(num, 0);
            if (count != 0) {
                if (!set.add(count))
                    return false;
            }
        }
        return true;
    }
}