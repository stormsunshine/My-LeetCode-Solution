class Solution {
    public double average(int[] salary) {
        int length = salary.length;
        double sum = 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : salary) {
            sum += num;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return (sum - max - min) / (length - 2);
    }
}