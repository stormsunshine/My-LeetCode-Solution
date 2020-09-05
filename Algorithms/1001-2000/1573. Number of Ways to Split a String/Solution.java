class Solution {
    public int numWays(String s) {
        final int MODULO = 1000000007;
        List<Integer> ones = new ArrayList<Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '1')
                ones.add(i);
        }
        int size = ones.size();
        if (size % 3 != 0)
            return 0;
        if (size == 0) {
            long ways = (long) (length - 1) * (length - 2) / 2;
            return (int) (ways % MODULO);
        } else {
            int index1 = size / 3, index2 = size / 3 * 2;
            int count1 = ones.get(index1) - ones.get(index1 - 1);
            int count2 = ones.get(index2) - ones.get(index2 - 1);
            long ways = (long) count1 * count2;
            return (int) (ways % MODULO);
        }
    }
}