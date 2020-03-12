class Solution {
    public boolean isArmstrong(int N) {
        char[] array = String.valueOf(N).toCharArray();
        int length = array.length;
        int sum = 0;
        for (char c : array) {
            int digit = c - '0';
            sum += (int) Math.pow(digit, length);
        }
        return sum == N;
    }
}