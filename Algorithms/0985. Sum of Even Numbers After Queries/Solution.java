class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int evenSum = 0;
        for (int num : A) {
            if (num % 2 == 0)
                evenSum += num;
        }
        int length = queries.length;
        int[] sumEvenEachQuery = new int[length];
        for (int i = 0; i < length; i++) {
            int[] query = queries[i];
            int value = query[0], index = query[1];
            int num = A[index];
            int newNum = num + value;
            A[index] = newNum;
            if (num % 2 == 0)
                evenSum -= num;
            if (newNum % 2 == 0)
                evenSum += newNum;
            sumEvenEachQuery[i] = evenSum;
        }
        return sumEvenEachQuery;
    }
}