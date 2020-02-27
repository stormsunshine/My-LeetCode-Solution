class Solution {
    public int minSwaps(int[] data) {
        int ones = 0;
        int length = data.length;
        for (int num : data) {
            if (num == 1)
                ones++;
        }
        if (ones <= 1)
            return 0;
        int windowOnes = 0;
        for (int i = 0; i < ones; i++) {
            if (data[i] == 1)
                windowOnes++;
        }
        int maxOnes = windowOnes;
        for (int i = ones; i < length; i++) {
            if (data[i - ones] == 1)
                windowOnes--;
            if (data[i] == 1)
                windowOnes++;
            maxOnes = Math.max(maxOnes, windowOnes);
            if (maxOnes == ones)
                break;
        }
        return ones - maxOnes;
    }
}