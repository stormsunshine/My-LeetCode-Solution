class Solution {
    public boolean isReflected(int[][] points) {
        int leftMost = Integer.MAX_VALUE, rightMost = Integer.MIN_VALUE;
        Set<String> pointsSet = new HashSet<String>();
        for (int[] point : points) {
            pointsSet.add(Arrays.toString(point));
            int x = point[0];
            leftMost = Math.min(leftMost, x);
            rightMost = Math.max(rightMost, x);
        }
        int sum = leftMost + rightMost;
        Set<String> reflectionPointsSet = new HashSet<String>();
        for (int[] point : points) {
            reflectionPointsSet.add(Arrays.toString(point));
            int[] reflectionPoint = {sum - point[0], point[1]};
            reflectionPointsSet.add(Arrays.toString(reflectionPoint));
        }
        return pointsSet.size() == reflectionPointsSet.size();
    }
}