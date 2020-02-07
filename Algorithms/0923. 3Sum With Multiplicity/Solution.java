class Solution {
    public int threeSumMulti(int[] A, int target) {
        final int MODULO = 1000000007;
        long count = 0;
        Arrays.sort(A);
        int length = A.length;
        int leftStart = 0, leftEnd = length - 3;
        for (int left = leftStart; left <= leftEnd; left++) {
            if (A[left] > target)
                break;
            int remainTarget = target - A[left];
            int mid = left + 1, right = length - 1;
            while (mid < right) {
                int sum = A[mid] + A[right];
                if (sum == remainTarget) {
                    if (A[mid] != A[right]) {
                        int midCount = 1, rightCount = 1;
                        while (mid + 1 < right && A[mid] == A[mid + 1]) {
                            mid++;
                            midCount++;
                        }
                        while (right - 1 > mid && A[right] == A[right - 1]) {
                            right--;
                            rightCount++;
                        }
                        count += midCount * rightCount;
                        count %= MODULO;
                        mid++;
                        right--;
                    } else {
                        int curCount = right - mid + 1;
                        count += curCount * (curCount - 1) / 2;
                        count %= MODULO;
                        break;
                    }
                } else if (sum < remainTarget)
                    mid++;
                else
                    right--;
            }
        }
        return (int) count;
    }
}