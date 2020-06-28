class Solution {
    public boolean canArrange(int[] arr, int k) {
        int length = arr.length;
        if (length % 2 != 0)
            return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : arr) {
            int remainder = num % k;
            if (remainder < 0)
                remainder += k;
            int count = map.getOrDefault(remainder, 0) + 1;
            map.put(remainder, count);
        }
        int count0 = map.getOrDefault(0, 0);
        if (count0 % 2 != 0)
            return false;
        if (k % 2 == 0) {
            int countHalf = map.getOrDefault(k / 2, 0);
            if (countHalf % 2 != 0)
                return false;
        }
        int half = k / 2;
        for (int i = 1; i <= half; i++) {
            int count1 = map.getOrDefault(i, 0);
            int count2 = map.getOrDefault(k - i, 0);
            if (count1 != count2)
                return false;
        }
        return true;
    }
}