class Solution {
    public int countPairs(int[] deliciousness) {
        final int MODULO = 1000000007;
        Map<Integer, Long> map = new HashMap<Integer, Long>();
        int max = 0;
        for (int num : deliciousness) {
            long count = map.getOrDefault(num, 0L) + 1;
            map.put(num, count);
            max = Math.max(max, num);
        }
        long pairs = 0;
        Set<Integer> keySet = map.keySet();
        for (int num : keySet) {
            long count = map.get(num);
            if (num > 0 && (num & (num - 1)) == 0)
                pairs = (pairs + count * (count - 1) / 2) % MODULO;
            int power2 = 1;
            while (power2 <= num * 2)
                power2 <<= 1;
            int upper = num + max;
            while (power2 <= upper) {
                int complement = power2 - num;
                if (map.containsKey(complement)) {
                    long complementCount = map.get(complement);
                    pairs = (pairs + count * complementCount) % MODULO;
                }
                power2 <<= 1;
            }
        }
        return (int) pairs;
    }
}