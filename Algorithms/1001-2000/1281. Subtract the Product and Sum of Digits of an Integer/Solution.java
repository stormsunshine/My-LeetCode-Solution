class Solution {
    public int subtractProductAndSum(int n) {
        if (n < 10)
            return 0;
        char[] array = String.valueOf(n).toCharArray();
        int length = array.length;
        int product = 1, sum = 0;
        for (int i = 0; i < length; i++) {
            int digit = array[i] - '0';
            product *= digit;
            sum += digit;
        }
        int difference = product - sum;
        return difference;
    }
}