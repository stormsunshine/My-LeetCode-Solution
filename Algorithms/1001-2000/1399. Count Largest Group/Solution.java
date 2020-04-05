class Solution {
    public int countLargestGroup(int n) {
        int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 1; i <= n; i++) {
            int sum = sumDigits(i);
            int count = map.getOrDefault(sum, 0) + 1;
            map.put(sum, count);
            maxCount = Math.max(maxCount, count);
        }
        int groups = 0;
        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            if (map.get(key) == maxCount)
                groups++;
        }
        return groups;
    }

    public int sumDigits(int num) {
        char[] array = String.valueOf(num).toCharArray();
        int sum = 0;
        for (char c : array)
            sum += c - '0';
        return sum;
    }
}