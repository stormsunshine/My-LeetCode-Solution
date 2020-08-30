class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int length = arr.length;
        int patternLength = m * k;
        for (int i = patternLength; i <= length; i++) {
            int start = i - patternLength;
            if (checkPattern(arr, m, k, start))
                return true;
        }
        return false;
    }

    public boolean checkPattern(int[] arr, int m, int k, int start) {
        for (int i = 0; i < m; i++) {
            int index = start + i;
            int num = arr[index];
            for (int j = 1; j < k; j++) {
                int nextIndex = index + m * j;
                int nextNum = arr[nextIndex];
                if (nextNum != num)
                    return false;
            }
        }
        return true;
    }
}