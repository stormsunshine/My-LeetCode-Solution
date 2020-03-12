class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int length = arr.length;
        int[] subLengths = new int[length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        subLengths[0] = 1;
        map.put(arr[0], 0);
        int max = 1;
        for (int i = 1; i < length; i++) {
            int num = arr[i];
            int prevNum = num - difference;
            if (map.containsKey(prevNum)) {
                int prevIndex = map.get(prevNum);
                subLengths[i] = subLengths[prevIndex] + 1;
                max = Math.max(max, subLengths[i]);
            } else
                subLengths[i] = 1;
            map.put(num, i);
        }
        return max;
    }
}