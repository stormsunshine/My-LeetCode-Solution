class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] left = new int[length];
        int[] right = new int[length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
        }
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
        }
        int sum = 0;
        for (int i = 0; i < length; i++)
            sum += Math.max(left[i], right[i]);
        return sum;
    }
}