class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        Map<Integer, Long> map = new HashMap<Integer, Long>();
        int length = segments.length;
        map.put(segments[0][0], (long) segments[0][2]);
        map.put(segments[0][1], (long) (-segments[0][2]));
        for (int i = 1; i < length; i++) {
            int[] segment = segments[i];
            int start = segment[0], end = segment[1];
            long color = segment[2];
            map.put(start, map.getOrDefault(start, 0L) + color);
            map.put(end, map.getOrDefault(end, 0L) - color);
        }
        List<List<Long>> paintings = new ArrayList<List<Long>>();
        List<Integer> keyList = new ArrayList<Integer>(map.keySet());
        Collections.sort(keyList);
        long currColor = 0;
        int size = keyList.size();
        for (int i = 1; i < size; i++) {
            int start = keyList.get(i - 1), end = keyList.get(i);
            long colorDiff = map.get(start);
            currColor += colorDiff;
            if (currColor != 0)
                paintings.add(Arrays.asList((long) start, (long) end, currColor));
        }
        return paintings;
    }
}