class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> maximumHeights = new ArrayList<Integer>();
        int maximumHeight = 0;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int length = positions.length;
        for (int i = 0; i < length; i++) {
            int[] position = positions[i];
            int left = position[0], height = position[1];
            int right = left + height;
            int prevHeight = 0;
            Integer prev = map.floorKey(left);
            if (prev != null)
                prevHeight = map.get(prev);
            Integer next = map.ceilingKey(left);
            int rightHeight = 0;
            Integer rightFloor = map.floorKey(right);
            if (rightFloor != null)
                rightHeight = map.get(rightFloor);
            while (next != null && next < right) {
                prevHeight = Math.max(prevHeight, map.get(next));
                map.remove(next);
                next = map.ceilingKey(left);
            }
            int newHeight = prevHeight + height;
            map.put(left, newHeight);
            map.put(right, rightHeight);
            maximumHeight = Math.max(maximumHeight, newHeight);
            maximumHeights.add(maximumHeight);
        }
        return maximumHeights;
    }
}