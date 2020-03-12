class Solution {
    public void duplicateZeros(int[] arr) {
        int length = arr.length;
        int slow = 0, fast = 0;
        while (fast < length) {
            int num = arr[slow];
            slow++;
            if (num == 0)
                fast += 2;
            else
                fast++;
        }
        if (fast == slow)
            return;
        if (arr[slow] == 0)
            fast++;
        while (fast >= length) {
            int num = arr[slow];
            slow--;
            if (num == 0) {
                fast -= 2;
                if (fast == length - 2)
                    arr[length - 1] = 0;
            } else
                fast--;
        }
        while (fast > slow) {
            int num = arr[slow];
            slow--;
            arr[fast] = num;
            fast--;
            if (num == 0) {
                arr[fast] = num;
                fast--;
            }
        }
    }
}