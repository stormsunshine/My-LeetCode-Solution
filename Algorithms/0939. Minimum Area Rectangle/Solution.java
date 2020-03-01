class Solution {
    public int minAreaRect(int[][] points) {
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<Integer, List<Integer>>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            List<Integer> list = treeMap.getOrDefault(x, new ArrayList<Integer>());
            list.add(y);
            treeMap.put(x, list);
        }
        int minArea = Integer.MAX_VALUE;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        Set<Integer> xValuesSet = treeMap.keySet();
        for (int x : xValuesSet) {
            List<Integer> list = treeMap.get(x);
            Collections.sort(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int y1 = list.get(i);
                for (int j = i + 1; j < size; j++) {
                    int y2 = list.get(j);
                    String positionKey = Arrays.toString(new int[]{y1, y2});
                    if (hashMap.containsKey(positionKey))
                        minArea = Math.min(minArea, (x - hashMap.get(positionKey)) * (y2 - y1));
                    hashMap.put(positionKey, x);
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}