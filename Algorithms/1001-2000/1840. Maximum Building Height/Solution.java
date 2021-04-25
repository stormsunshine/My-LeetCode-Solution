class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, new Comparator<int[]>() {
            public int compare(int[] restriction1, int[] restriction2) {
                return restriction1[0] - restriction2[0];
            }
        });
        int maxHeight = 0;
        int length = restrictions.length;
        int prevId = 1, prevHeight = 0;
        for (int i = 0; i < length; i++) {
            int[] restriction = restrictions[i];
            int currId = restriction[0], currHeight = restriction[1];
            int difference = currId - prevId;
            restrictions[i][1] = Math.min(restrictions[i][1], prevHeight + difference);
            prevId = currId;
            prevHeight = restrictions[i][1];
        }
        for (int i = length - 2; i >= 0; i--) {
            int difference = restrictions[i + 1][0] - restrictions[i][0];
            restrictions[i][1] = Math.min(restrictions[i][1], restrictions[i + 1][1] + difference);
        }
        prevId = 1;
        prevHeight = 0;
        for (int i = 0; i < length; i++) {
            int[] restriction = restrictions[i];
            int currId = restriction[0], currHeight = restriction[1];
            int difference = currId - prevId;
            restrictions[i][1] = Math.min(restrictions[i][1], prevHeight + difference);
            int heightDifference = Math.abs(currHeight - prevHeight);
            int curMaxHeight = (difference + heightDifference) / 2 + Math.min(prevHeight, currHeight);
            maxHeight = Math.max(maxHeight, curMaxHeight);
            prevId = currId;
            prevHeight = currHeight;
        }
        int lastHeight = prevHeight + (n - prevId);
        maxHeight = Math.max(maxHeight, lastHeight);
        return maxHeight;
    }
}