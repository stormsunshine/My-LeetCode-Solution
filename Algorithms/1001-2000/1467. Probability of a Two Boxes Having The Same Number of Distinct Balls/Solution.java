class Solution {
    double[] factorials = {1, 1, 2, 6, 24, 120, 720};
    double sameDistinctCount = 0;

    public double getProbability(int[] balls) {
        double totalCount = calculatePermutations(balls);
        backtrack(0, balls, new int[balls.length]);
        return sameDistinctCount / totalCount;
    }

    public double calculatePermutations(int[] balls) {
        int length = balls.length;
        double[] total = new double[length];
        total[0] = 1;
        int sum = balls[0];
        for (int i = 1; i < length; i++) {
            total[i] = total[i - 1];
            int max = sum + balls[i];
            for (int j = sum + 1; j <= max; j++)
                total[i] *= j;
            total[i] /= factorials[balls[i]];
            sum += balls[i];
        }
        return total[length - 1];
    }

    public void backtrack(int start, int[] box1, int[] box2) {
        int length = box1.length;
        if (start == length) {
            int count1 = 0, count2 = 0, sum1 = 0, sum2 = 0;
            for (int i = 0; i < length; i++) {
                sum1 += box1[i];
                sum2 += box2[i];
                if (box1[i] > 0)
                    count1++;
                if (box2[i] > 0)
                    count2++;
            }
            if (count1 == count2 && sum1 == sum2)
                sameDistinctCount += calculatePermutations(box1) * calculatePermutations(box2);
        } else {
            int max = box1[start];
            for (int i = 0; i <= max; i++) {
                box1[start] -= i;
                box2[start] += i;
                backtrack(start + 1, box1, box2);
                box1[start] += i;
                box2[start] -= i;
            }
        }
    }
}