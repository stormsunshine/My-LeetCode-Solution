class Solution {
    public int longestAwesome(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int length = s.length();
        int[][] counts = new int[length][10];
        int digit0 = s.charAt(0) - '0';
        counts[0][digit0] = 1;
        int num0 = countsToNum(counts[0]);
        List<Integer> list0 = new ArrayList<Integer>();
        list0.add(0);
        map.put(num0, list0);
        for (int i = 1; i < length; i++) {
            int digit = s.charAt(i) - '0';
            for (int j = 0; j <= 9; j++)
                counts[i][j] = counts[i - 1][j];
            counts[i][digit] = 1 - counts[i][digit];
            int num = countsToNum(counts[i]);
            List<Integer> list = map.getOrDefault(num, new ArrayList<Integer>());
            list.add(i);
            map.put(num, list);
        }
        int maxLength = 1;
        Set<Integer> visited = new HashSet<Integer>();
        for (int i = length - 1; i > 0; i--) {
            int num = countsToNum(counts[i]);
            if (num == 0 || (num & (num - 1)) == 0)
                maxLength = Math.max(maxLength, i + 1);
            else if (visited.add(num)) {
                int[] curCounts = new int[10];
                System.arraycopy(counts[i], 0, curCounts, 0, 10);
                List<Integer> list = map.get(num);
                if (list.size() > 1)
                    maxLength = Math.max(maxLength, i - list.get(0));
                for (int j = 0; j <= 9; j++) {
                    curCounts[j] = 1 - curCounts[j];
                    int newNum = countsToNum(curCounts);
                    if (map.containsKey(newNum)) {
                        List<Integer> newList = map.get(newNum);
                        maxLength = Math.max(maxLength, i - newList.get(0));
                    }
                    curCounts[j] = 1 - curCounts[j];
                }
            }
        }
        return maxLength;
    }

    public int countsToNum(int[] counts) {
        int num = 0;
        int base = 1;
        int length = counts.length;
        for (int i = 0; i < length; i++) {
            num += counts[i] * base;
            base *= 2;
        }
        return num;
    }
}