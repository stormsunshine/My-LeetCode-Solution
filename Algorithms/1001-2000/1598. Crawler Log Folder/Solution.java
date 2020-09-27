class Solution {
    public int minOperations(String[] logs) {
        int level = 0;
        int length = logs.length;
        for (int i = 0; i < length; i++) {
            String log = logs[i];
            if (log.equals("../"))
                level = Math.max(level - 1, 0);
            else if (log.equals("./"))
                continue;
            else
                level++;
        }
        return level;
    }
}