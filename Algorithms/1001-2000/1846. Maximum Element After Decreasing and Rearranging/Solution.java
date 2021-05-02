class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        arr[0] = 1;
        for (int i = 1; i < length; i++)
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        return arr[length - 1];
    }
}