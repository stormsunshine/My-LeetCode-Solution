class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        TreeSet<Integer> completeSet = new TreeSet<Integer>();
        TreeSet<Integer> repeatSet = new TreeSet<Integer>();
        int length = fronts.length;
        for (int i = 0; i < length; i++) {
            completeSet.add(fronts[i]);
            completeSet.add(backs[i]);
            if (fronts[i] == backs[i])
                repeatSet.add(fronts[i]);
        }
        int size1 = completeSet.size(), size2 = repeatSet.size();
        if (size1 == size2)
            return 0;
        if (size2 == 0)
            return completeSet.first();
        int index2 = 0;
        while (index2 < size2) {
            int num = completeSet.pollFirst();
            int repeat = repeatSet.pollFirst();
            if (num < repeat)
                return num;
            index2++;
        }
        return completeSet.first();
    }
}