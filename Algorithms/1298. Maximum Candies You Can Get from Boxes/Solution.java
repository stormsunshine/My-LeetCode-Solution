class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int maxCandies = 0;
        int length = status.length;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int initialBox : initialBoxes)
            queue.offer(initialBox);
        int index = 0;
        int size = queue.size();
        while (!queue.isEmpty()) {
            boolean flag = false;
            int box = queue.poll();
            if (status[box] == 0) {
                queue.offer(box);
                index++;
                size = queue.size();
            } else {
                maxCandies += candies[box];
                int[] curKeys = keys[box];
                int[] nextBoxes = containedBoxes[box];
                if (curKeys != null && curKeys.length > 0) {
                    index = 0;
                    for (int key : curKeys)
                        status[key] = 1;
                }
                if (nextBoxes != null && nextBoxes.length > 0) {
                    index = 0;
                    for (int nextBox : nextBoxes)
                        queue.offer(nextBox);
                }
            }
            if (index == size)
                break;
        }
        return maxCandies;
    }
}