class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A)
            sum += num;
        if (sum % 3 != 0)
            return false;
        int partSum = sum / 3;
        int count = 0;
        int curSum = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            curSum += A[i];
            if (curSum == partSum * (count + 1))
                count++;
        }
        return count >= 3;
    }
}