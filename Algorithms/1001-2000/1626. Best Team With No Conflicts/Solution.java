class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int length = scores.length;
        int[][] scoresAges = new int[length][2];
        for (int i = 0; i < length; i++) {
            scoresAges[i][0] = scores[i];
            scoresAges[i][1] = ages[i];
        }
        Arrays.sort(scoresAges, new Comparator<int[]>() {
            public int compare(int[] scoreAge1, int[] scoreAge2) {
                if (scoreAge1[0] != scoreAge2[0])
                    return scoreAge2[0] - scoreAge1[0];
                else
                    return scoreAge2[1] - scoreAge1[1];
            }
        });
        Map<Integer, List<Integer>> conflictMap = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i < length; i++) {
            List<Integer> conflictList = new ArrayList<Integer>();
            int score = scoresAges[i][0], age = scoresAges[i][1];
            for (int j = 0; j < i; j++) {
                if (scoresAges[j][0] == score)
                    break;
                if (scoresAges[j][1] > age)
                    conflictList.add(j);
            }
            conflictMap.put(i, conflictList);
        }
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = scoresAges[0][0];
        for (int i = 1; i < length; i++) {
            int score = scoresAges[i][0], age = scoresAges[i][1];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = score;
            for (int j = 0; j < i; j++) {
                if (age <= scoresAges[j][1])
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + score);
            }
        }
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }
}