class Solution {
    public boolean isIdealPermutation(int[] A) {
        if (A == null)
            return false;
        if (A.length <= 2)
            return true;
        int length = A.length;
        if (A[0] > 1)
            return false;
        for (int i = 1; i < length; i++) {
            int prev = A[i - 1], cur = A[i];
            if (cur != i && cur != i - 1 && cur != i + 1)
                return false;
            if (cur == i - 1 && prev != i)
                return false;
        }
        return true;
    }
}