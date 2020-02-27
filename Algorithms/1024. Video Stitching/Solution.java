class Solution {
    public int videoStitching(int[][] clips, int T) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] clip1, int[] clip2) {
                if (clip1[0] != clip2[0])
                    return clip1[0] - clip2[0];
                else
                    return clip2[1] - clip1[1];
            }
        });
        for (int[] clip : clips)
            priorityQueue.offer(clip);
        int count = 0;
        int curEnd = 0;
        while (!priorityQueue.isEmpty() && curEnd < T) {
            int[] clip = priorityQueue.poll();
            int start = clip[0], end = clip[1];
            if (start > curEnd)
                return -1;
            if (end > curEnd) {
                curEnd = end;
                count++;
            }
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] < curEnd) {
                int[] nextClip = priorityQueue.poll();
                nextClip[0] = curEnd;
                if (nextClip[0] < nextClip[1])
                    priorityQueue.offer(nextClip);
            }
        }
        return curEnd >= T ? count : -1;
    }
}