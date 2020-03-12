class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        Arrays.sort(slots2, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<Integer> minAvailable = new ArrayList<Integer>();
        int length1 = slots1.length, length2 = slots2.length;
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int[] slot1 = slots1[index1];
            int[] slot2 = slots2[index2];
            int start = Math.max(slot1[0], slot2[0]);
            int end = Math.min(slot1[1], slot2[1]);
            if (end - start >= duration) {
                end = start + duration;
                minAvailable.add(start);
                minAvailable.add(end);
                break;
            } else {
                if (slot1[1] <= slot2[1])
                    index1++;
                if (slot1[1] >= slot2[1])
                    index2++;
            }
        }
        return minAvailable;
    }
}