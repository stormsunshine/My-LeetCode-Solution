class Solution {
    public boolean splitString(String s) {
        int length = s.length();
        long firstNum = 0;
        for (int i = 0; i < length - 1; i++) {
            firstNum = firstNum * 10 + (s.charAt(i) - '0');
            boolean flag = backtrack(s, 1, firstNum, i + 1);
            if (flag)
                return true;
        }
        return false;
    }

    public boolean backtrack(String s, int count, long prev, int start) {
        int length = s.length();
        if (start == length)
            return count > 1;
        for (int i = start + 1; i <= length; i++) {
            String currStr = s.substring(start, i);
            long curr = Long.parseLong(currStr);
            if (curr >= prev)
                break;
            if (prev - curr == 1) {
                boolean flag = backtrack(s, count + 1, curr, i);
                if (flag)
                    return true;
            }
        }
        return false;
    }
}