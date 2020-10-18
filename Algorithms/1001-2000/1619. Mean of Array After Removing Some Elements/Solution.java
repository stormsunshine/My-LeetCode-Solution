class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        int removeCount = length / 20;
        int start = removeCount, end = length - removeCount;
        double sum = 0;
        for (int i = start; i < end; i++)
            sum += arr[i];
        return sum / (length - removeCount * 2);
    }
}