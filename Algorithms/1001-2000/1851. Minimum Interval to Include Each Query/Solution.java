class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int query : queries)
            set.add(query);
        int intervalsCount = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                int length1 = interval1[1] - interval1[0] + 1, length2 = interval2[1] - interval2[0] + 1;
                if (length1 != length2)
                    return length1 - length2;
                else
                    return interval1[0] - interval2[0];
            }
        });
        for (int i = 0; i < intervalsCount; i++) {
            int[] interval = intervals[i];
            int start = interval[0], end = interval[1];
            int size = end - start + 1;
            Set<Integer> subSet = new HashSet<Integer>(set.subSet(start, true, end, true));
            for (int num : subSet) {
                map.put(num, size);
                set.remove(num);
            }
        }
        int queriesCount = queries.length;
        int[] answers = new int[queriesCount];
        for (int i = 0; i < queriesCount; i++)
            answers[i] = map.getOrDefault(queries[i], -1);
        return answers;
    }
}