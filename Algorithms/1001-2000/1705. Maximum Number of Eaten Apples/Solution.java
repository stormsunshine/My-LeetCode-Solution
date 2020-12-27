class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int maxApples = 0;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int length = apples.length;
        for (int i = 0; i < length; i++) {
            int apple = apples[i], day = days[i];
            if (apple != 0) {
                int maxDay = i + day - 1;
                int count = map.getOrDefault(maxDay, 0) + apple;
                map.put(maxDay, count);
            }
            while (!map.isEmpty() && map.firstKey() < i)
                map.remove(map.firstKey());
            if (!map.isEmpty()) {
                Integer firstKey = map.firstKey();
                if (firstKey != null) {
                    maxApples++;
                    int count = map.get(firstKey) - 1;
                    if (count > 0)
                        map.put(firstKey, count);
                    else
                        map.remove(firstKey);
                }
            }
        }
        int index = length;
        while (!map.isEmpty()) {
            while (!map.isEmpty() && map.firstKey() < index)
                map.remove(map.firstKey());
            if (map.isEmpty())
                break;
            int firstKey = map.firstKey();
            if (firstKey >= index) {
                int count = map.get(firstKey);
                map.remove(firstKey);
                int curApples = Math.min(firstKey - index + 1, count);
                maxApples += curApples;
                index += curApples;
            } else
                break;
        }
        return maxApples;
    }
}