class Solution {
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, new Comparator<int[]>() {
            public int compare(int[] item1, int[] item2) {
                if (item1[0] != item2[0])
                    return item1[0] - item2[0];
                else
                    return item2[1] - item1[1];
            }
        });
        List<int[]> list = new ArrayList<int[]>();
        int length = items.length;
        int curId = 1;
        int scoresSum = 0;
        int scoresCount = 0;
        for (int i = 0; i < length; i++) {
            int[] item = items[i];
            int id = item[0], score = item[1];
            if (id > curId)
                curId = id;
            if (id == curId) {
                scoresSum += score;
                scoresCount++;
                if (scoresCount == 5) {
                    list.add(new int[]{id, scoresSum / scoresCount});
                    curId++;
                    scoresSum = 0;
                    scoresCount = 0;
                }
            }
        }
        int size = list.size();
        int[][] highFive = new int[size][2];
        for (int i = 0; i < size; i++) {
            int[] idScore = list.get(i);
            highFive[i][0] = idScore[0];
            highFive[i][1] = idScore[1];
        }
        return highFive;
    }
}