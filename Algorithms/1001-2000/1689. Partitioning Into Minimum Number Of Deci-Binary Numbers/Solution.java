class Solution {
    public int minPartitions(String n) {
        int max = 0;
        int length = n.length();
        for (int i = 0; i < length; i++) {
            int digit = n.charAt(i) - '0';
            max = Math.max(max, digit);
        }
        return max;
    }
}