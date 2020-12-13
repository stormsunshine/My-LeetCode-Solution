class Solution {
    public int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids)
            Arrays.sort(cuboid);
        Arrays.sort(cuboids, new Comparator<int[]>() {
            public int compare(int[] cuboid1, int[] cuboid2) {
                if (cuboid1[0] != cuboid2[0])
                    return cuboid1[0] - cuboid2[0];
                else if (cuboid1[1] != cuboid2[1])
                    return cuboid1[1] - cuboid2[1];
                else
                    return cuboid1[2] - cuboid2[2];
            }
        });
        int maxHeight = 0;
        int cuboidsCount = cuboids.length;
        int[] dp = new int[cuboidsCount];
        for (int i = 0; i < cuboidsCount; i++) {
            int height = cuboids[i][2];
            maxHeight = Math.max(maxHeight, height);
            dp[i] = height;
        }
        for (int i = 1; i < cuboidsCount; i++) {
            int width = cuboids[i][0], length = cuboids[i][1], height = cuboids[i][2];
            for (int j = i - 1; j >= 0; j--) {
                if (cuboids[j][0] <= width && cuboids[j][1] <= length && cuboids[j][2] <= height) {
                    int totalHeight = dp[j] + height;
                    maxHeight = Math.max(maxHeight, totalHeight);
                    dp[i] = Math.max(dp[i], totalHeight);
                }
            }
        }
        return maxHeight;
    }
}