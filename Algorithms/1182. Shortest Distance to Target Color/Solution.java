class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        final int MAX_LENGTH = 50000;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> distances = new ArrayList<Integer>();
        int colorsLength = colors.length;
        int queriesCount = queries.length;
        outer:
        for (int i = 0; i < queriesCount; i++) {
            int[] query = queries[i];
            int index = query[0], color = query[1];
            if (colors[index] == color)
                distances.add(0);
            else {
            	int key = color * MAX_LENGTH + index;
                if (map.containsKey(key)) {
                    int distance = map.get(key);
                    distances.add(distance);
                    continue;
                }
                int step = 1;
                int left = index - step, right = index + step;
                while (left >= 0 || right < colorsLength) {
                    if (left >= 0 && right < colorsLength) {
                        int leftColor = colors[left], rightColor = colors[right];
                        if (leftColor == color || rightColor == color) {
                            distances.add(step);
                            map.put(key, step);
                            continue outer;
                        } else {
                            left--;
                            right++;
                            step++;
                        }
                    } else if (left >= 0) {
                        int leftColor = colors[left];
                        if (leftColor == color) {
                            distances.add(step);
                            map.put(key, step);
                            continue outer;
                        } else {
                            left--;
                            step++;
                        }
                    } else {
                        int rightColor = colors[right];
                        if (rightColor == color) {
                            distances.add(step);
                            map.put(key, step);
                            continue outer;
                        } else {
                            right++;
                            step++;
                        }
                    }
                }
                distances.add(-1);
            }
        }
        return distances;
    }
}