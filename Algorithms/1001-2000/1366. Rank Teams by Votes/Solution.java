class Solution {
    public String rankTeams(String[] votes) {
        int teams = votes[0].length();
        int[][] votesCount = new int[26][teams + 1];
        for (int i = 0; i < 26; i++)
            votesCount[i][teams] = i;
        for (String vote : votes) {
            for (int i = 0; i < teams; i++) {
                char c = vote.charAt(i);
                votesCount[c - 'A'][i]++;
            }
        }
        Arrays.sort(votesCount, new Comparator<int[]>() {
            public int compare(int[] voteCount1, int[] voteCount2) {
                for (int i = 0; i < teams; i++) {
                    if (voteCount1[i] != voteCount2[i])
                        return voteCount2[i] - voteCount1[i];
                }
                return voteCount1[teams] - voteCount2[teams];
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < teams; i++) {
            char team = (char) ('A' + votesCount[i][teams]);
            sb.append(team);
        }
        return sb.toString();
    }
}