class Solution {
    public int findRotateSteps(String ring, String key) {
        final int INFINITY = Integer.MAX_VALUE / 10;
        Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        int ringLength = ring.length(), keyLength = key.length();
        for (int i = 0; i < ringLength; i++) {
            char c = ring.charAt(i);
            List<Integer> list = map.getOrDefault(c, new ArrayList<Integer>());
            list.add(i);
            map.put(c, list);
        }
        int[] dp = new int[ringLength];
        Arrays.fill(dp, INFINITY);
        dp[0] = 0;
        for (int i = 0; i < keyLength; i++) {
            List<Integer> prevList = i == 0 ? new ArrayList<Integer>(Arrays.asList(0)) : map.get(key.charAt(i - 1));
            char prevC = i == 0 ? ring.charAt(0) : key.charAt(i - 1);
            char currC = key.charAt(i);
            if (prevC == currC) {
                for (int prevIndex : prevList)
                    dp[prevIndex]++;
            } else {
                List<Integer> currList = map.get(currC);
                for (int currIndex : currList) {
                    for (int prevIndex : prevList) {
                        int difference = Math.abs(currIndex - prevIndex);
                        dp[currIndex] = Math.min(dp[currIndex], 1 + dp[prevIndex] + Math.min(difference, ringLength - difference));
                    }
                }
                for (int prevIndex : prevList)
                    dp[prevIndex] = INFINITY;
            }
        }
        int minSteps = INFINITY;
        for (int steps : dp)
            minSteps = Math.min(minSteps, steps);
        return minSteps;
    }
}