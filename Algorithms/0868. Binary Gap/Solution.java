class Solution {
    public int binaryGap(int N) {
        if (N <= 2)
            return 0;
        List<Integer> list = new ArrayList<Integer>();
        int position = 0;
        while (N > 0) {
            int curDigit = N & 1;
            if (curDigit == 1)
                list.add(position);
            N >>>= 1;
            position++;
        }
        int size = list.size();
        if (size <= 1)
            return 0;
        int max = 0;
        for (int i = 1; i < size; i++) {
            int prev = list.get(i - 1), cur = list.get(i);
            max = Math.max(max, cur - prev);
        }
        return max;
    }
}