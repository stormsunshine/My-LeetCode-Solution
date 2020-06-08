class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int length = arr.length;
        int medianIndex = (length - 1) / 2;
        int median = arr[medianIndex];
        int[] strongest = new int[k];
        int low = 0, high = length - 1;
        for (int i = 0; i < k; i++) {
            int num1 = arr[low], num2 = arr[high];
            int difference1 = median - num1, difference2 = num2 - median;
            if (difference1 > difference2) {
                strongest[i] = num1;
                low++;
            } else {
                strongest[i] = num2;
                high--;
            }
        }
        return strongest;
    }
}