class Solution {
    public String findContestMatch(int n) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 1; i <= n; i++)
            map.put(i, String.valueOf(i));
        while (n > 1) {
            int half = n / 2;
            int sum = 1 + n;
            for (int i = 1; i <= half; i++) {
                int j = sum - i;
                String str1 = map.get(i), str2 = map.get(j);
                String newStr = "(" + str1 + "," + str2 + ")";
                map.put(i, newStr);
            }
            n /= 2;
        }
        String finalMatches = map.get(1);
        return finalMatches;
    }
}