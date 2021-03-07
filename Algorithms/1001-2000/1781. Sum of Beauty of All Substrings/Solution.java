class Solution {
    public int beautySum(String s) {
        int sum = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int[] counts = new int[26];
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for (int j = i; j < length; j++) {
                char c = s.charAt(j);
                int index = c - 'a';
                counts[index]++;
                int count = counts[index];
                map.put(count, map.getOrDefault(count, 0) + 1);
                if (map.containsKey(count - 1)) {
                    map.put(count - 1, map.get(count - 1) - 1);
                    if (map.get(count - 1) == 0)
                        map.remove(count - 1);
                }
                int maxFreq = map.lastKey();
                int minFreq = map.firstKey();
                sum += maxFreq - minFreq;
            }
        }
        return sum;
    }
}