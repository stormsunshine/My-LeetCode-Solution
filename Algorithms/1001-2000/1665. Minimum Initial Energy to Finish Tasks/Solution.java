class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, new Comparator<int[]>() {
            public int compare(int[] task1, int[] task2) {
                return (task2[1] - task2[0]) - (task1[1] - task1[0]);
            }
        });
        int minEnergy = 0;
        int sum = 0;
        int length = tasks.length;
        for (int i = 0; i < length; i++) {
            int[] task = tasks[i];
            minEnergy = Math.max(minEnergy, sum + task[1]);
            sum += task[0];
        }
        return minEnergy;
    }
}