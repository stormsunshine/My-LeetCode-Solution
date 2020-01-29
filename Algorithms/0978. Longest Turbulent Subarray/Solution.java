class Solution {
    public int maxTurbulenceSize(int[] A) {
        if (A == null)
            return 0;
        int length = A.length;
        if (length < 2)
            return length;
        int start = 0;
        while (start < length - 1 && A[start] == A[start + 1])
            start++;
        if (start == length - 1)
            return 1;
        int maxSize = 2;
        int difference = A[start + 1] - A[start];
        if (difference > 0)
            difference = 1;
        else
            difference = -1;
        int index = start + 2;
        while (index < length) {
            int curDifference = A[index] - A[index - 1];
            if (curDifference * difference >= 0) {
                maxSize = Math.max(maxSize, index - start);
                start = index - 1;
                while (start < length - 1 && A[start] == A[start + 1])
                    start++;
                if (start == length - 1)
                    break;
                int nextDifference = A[start + 1] - A[start];
                difference = nextDifference > 0 ? 1 : -1;
                index = start + 2;
            } else {
                index++;
                difference = -difference;
            }
        }
        maxSize = Math.max(maxSize, index - start);
        return maxSize;
    }
}