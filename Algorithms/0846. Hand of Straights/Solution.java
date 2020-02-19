class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length == 0)
            return false;
        int length = hand.length;
        if (length % W != 0)
            return false;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int num : hand) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        while (map.size() > 0) {
            int start = map.firstKey();
            int end = start + W - 1;
            for (int i = start; i <= end; i++) {
                int count = map.getOrDefault(i, 0);
                if (count == 0)
                    return false;
                count--;
                if (count == 0)
                    map.remove(i);
                else
                    map.put(i, count);
            }
        }
        return true;
    }
}