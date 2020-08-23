class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] visits = new int[n];
        visits[rounds[0] - 1]++;
        int maxVisit = 1;
        int roundsCount = rounds.length;
        for (int i = 1; i < roundsCount; i++) {
            int start = rounds[i - 1] - 1, end = rounds[i] - 1;
            int curLength = (end - start + n) % n;
            int index = start;
            for (int j = 0; j < curLength; j++) {
                index = (index + 1) % n;
                visits[index]++;
                maxVisit = Math.max(maxVisit, visits[index]);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (visits[i] == maxVisit)
                list.add(i + 1);
        }
        return list;
    }
}