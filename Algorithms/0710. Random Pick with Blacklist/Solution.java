class Solution {
    int size;
    Set<Integer> blacklistSet;
    Map<Integer, Integer> map;

    public Solution(int N, int[] blacklist) {
        size = N - blacklist.length;
        blacklistSet = new HashSet<Integer>();
        for (int blacklistNum : blacklist)
            blacklistSet.add(blacklistNum);
        map = new HashMap<Integer, Integer>();
        int num = size;
        for (int blacklistNum : blacklist) {
            if (blacklistNum < size) {
                while (blacklistSet.contains(num))
                    num++;
                map.put(blacklistNum, num);
                num++;
            }
        }
    }
    
    public int pick() {
        int num = (int) (Math.random() * size);
        num = map.getOrDefault(num, num);
        return num;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */