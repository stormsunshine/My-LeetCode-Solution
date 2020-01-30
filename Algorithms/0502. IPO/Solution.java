class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int length = Profits.length;
        int[][] profitsCapital = new int[length][2];
        for (int i = 0; i < length; i++) {
            profitsCapital[i][0] = Profits[i];
            profitsCapital[i][1] = Capital[i];
        }
        Arrays.sort(profitsCapital, new Comparator<int[]>() {
            public int compare(int[] profitsCapital1, int[] profitsCapital2) {
                return profitsCapital1[1] - profitsCapital2[1];
            }
        });
        int totalCapital = W;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer profit1, Integer profit2) {
                return profit2 - profit1;
            }
        });
        int index = 0;
        while (k > 0) {
            while (index < length && profitsCapital[index][1] <= totalCapital) {
                priorityQueue.offer(profitsCapital[index][0]);
                index++;
            }
            if (priorityQueue.isEmpty())
                break;
            totalCapital += priorityQueue.poll();
            k--;
        }
        return totalCapital;
    }
}