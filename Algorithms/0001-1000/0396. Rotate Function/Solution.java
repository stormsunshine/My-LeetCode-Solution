public class Solution {
    public int maxRotateFunction(int[] A) {
        int length = A.length;
        if (length <= 1)
            return 0;
        int sum = 0, function = 0;
        for (int i = 0; i < length; i++) {
            sum += A[i];
            function += i * A[i];
        }
        int max = function;
        for (int i = 1; i < length; i++) {
            function = function + sum - length * A[length - i];
            max = Math.max(max, function);
        }
        return max;
    }
}