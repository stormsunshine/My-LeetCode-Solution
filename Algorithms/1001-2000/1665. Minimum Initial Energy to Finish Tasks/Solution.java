class Solution {
    public int minimumEffort(int[][] tasks) {
        int sum = 0;
        int minDifference = Integer.MAX_VALUE;
        int minRequired = 0;
        for (int[] task : tasks) {
            sum += task[0];
            int difference = task[1] - task[0];
            minDifference = Math.min(minDifference, difference);
            minRequired = Math.max(minRequired, task[1]);
        }
        return Math.max(sum + minDifference, minRequired);
    }
}