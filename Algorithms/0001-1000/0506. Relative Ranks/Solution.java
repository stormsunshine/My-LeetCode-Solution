class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int length = nums.length;
        int[][] scoresIndices = new int[length][2];
        for (int i = 0; i < length; i++) {
            scoresIndices[i][0] = nums[i];
            scoresIndices[i][1] = i;
        }
        Arrays.sort(scoresIndices, new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                if (array1[0] != array2[0])
                    return array2[0] - array1[0];
                else
                    return array1[1] - array2[1];
            }
        });
        String[] ranks = new String[length];
        for (int i = 0; i < length; i++) {
            int index = scoresIndices[i][1];
            int rank = i + 1;
            if (rank == 1)
                ranks[index] = "Gold Medal";
            else if (rank == 2)
                ranks[index] = "Silver Medal";
            else if (rank == 3)
                ranks[index] = "Bronze Medal";
            else
                ranks[index] = String.valueOf(rank);
        }
        return ranks;
    }
}