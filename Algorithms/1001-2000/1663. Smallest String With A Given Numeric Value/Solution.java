class Solution {
    public String getSmallestString(int n, int k) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int remainLength = n - i - 1;
            int remainSum = 26 * remainLength;
            array[i] = Math.max(1, k - remainSum);
            k -= array[i];
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            char c = (char) ('a' + array[i] - 1);
            sb.append(c);
        }
        return sb.toString();
    }
}