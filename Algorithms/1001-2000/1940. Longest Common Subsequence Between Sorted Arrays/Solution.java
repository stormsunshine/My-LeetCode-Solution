class Solution {
    public List<Integer> longestCommomSubsequence(int[][] arrays) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = arrays.length;
        int shortestIndex = 0, shortestLength = arrays[0].length;
        for (int i = 0; i < count; i++) {
            int[] array = arrays[i];
            if (array.length < shortestLength) {
                shortestIndex = i;
                shortestLength = array.length;
            }
            for (int num : array)
                map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> subsequence = new ArrayList<Integer>();
        int[] shortestArray = arrays[shortestIndex];
        for (int i = 0; i < shortestLength; i++) {
            int num = shortestArray[i];
            if (map.get(num) == count)
                subsequence.add(num);
        }
        return subsequence;
    }
}