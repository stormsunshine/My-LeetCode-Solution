class Solution {
    public int countNicePairs(int[] nums) {
        final int MODULO = 1000000007;
        int length = nums.length;
        int[] differences = new int[length];
        for (int i = 0; i < length; i++) {
            int reverseNum = reverse(nums[i]);
            differences[i] = nums[i] - reverseNum;
        }
        Arrays.sort(differences);
        long pairs = 0;
        int prev = differences[0];
        long consecutive = 1;
        for (int i = 1; i < length; i++) {
            int curr = differences[i];
            if (curr == prev)
                consecutive++;
            else {
                pairs = (pairs + consecutive * (consecutive - 1) / 2) % MODULO;
                prev = curr;
                consecutive = 1;
            }
        }
        pairs = (pairs + consecutive * (consecutive - 1) / 2) % MODULO;
        return (int) pairs;
    }

    public int reverse(int x) {
        int max = Integer.MAX_VALUE / 10, min = Integer.MIN_VALUE / 10;
        int reversed = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            if (reversed > max || reversed == max && lastDigit > 7)
                return 0;
            if (reversed < min || reversed == min && lastDigit < -8)
                return 0;
            x /= 10;
            reversed = reversed * 10 + lastDigit;
        }
        return reversed;
    }
}