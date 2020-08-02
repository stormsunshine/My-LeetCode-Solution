class Solution {
    public int getWinner(int[] arr, int k) {
        int prev = Math.max(arr[0], arr[1]);
        if (k == 1)
            return prev;
        int consecutive = 1;
        int max = prev;
        int length = arr.length;
        for (int i = 2; i < length; i++) {
            int curr = arr[i];
            if (prev > curr) {
                consecutive++;
                if (consecutive == k)
                    return prev;
            } else {
                prev = curr;
                consecutive = 1;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}