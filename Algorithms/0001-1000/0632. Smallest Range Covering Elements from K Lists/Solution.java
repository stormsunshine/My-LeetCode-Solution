class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
        int minRange = rangeRight - rangeLeft;
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        int[] next = new int[size];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return nums.get(num1).get(next[num1]) - nums.get(num2).get(next[num2]);
            }
        });
        for (int i = 0; i < size; i++) {
            priorityQueue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        outer:
        for (int i = 0; i < size; i++) {
            List<Integer> list = nums.get(i);
            int length = list.size();
            for (int j = 0; j < length; j++) {
                int min = priorityQueue.poll();
                int curRange = max - nums.get(min).get(next[min]);
                if (curRange < minRange) {
                    minRange = curRange;
                    rangeLeft = nums.get(min).get(next[min]);
                    rangeRight = max;
                }
                next[min]++;
                if (next[min] == nums.get(min).size())
                    break outer;
                priorityQueue.offer(min);
                max = Math.max(max, nums.get(min).get(next[min]));
            }
        }
        return new int[]{rangeLeft, rangeRight};
    }
}