class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                long increase1Numerator = (long) arr1[1] - (long) arr1[0];
                long increase1Denominator = (long) arr1[1] * (long) (arr1[1] + 1);
                long increase2Numerator = (long) arr2[1] - (long) arr2[0];
                long increase2Denominator = (long) arr2[1] * (long) (arr2[1] + 1);
                long difference = increase2Numerator * increase1Denominator - increase1Numerator * increase2Denominator;
                if (difference > 0)
                    return 1;
                else if (difference < 0)
                    return -1;
                else
                    return 0;
            }
        });
        for (int[] arr : classes)
            priorityQueue.offer(new int[]{arr[0], arr[1]});
        for (int i = 0; i < extraStudents; i++) {
            int[] arr = priorityQueue.poll();
            int[] newArr = {arr[0] + 1, arr[1] + 1};
            priorityQueue.offer(newArr);
        }
        double averageRatio = 0;
        while (!priorityQueue.isEmpty()) {
            int[] arr = priorityQueue.poll();
            averageRatio += 1.0 * arr[0] / arr[1];
        }
        averageRatio /= classes.length;
        return averageRatio;
    }
}