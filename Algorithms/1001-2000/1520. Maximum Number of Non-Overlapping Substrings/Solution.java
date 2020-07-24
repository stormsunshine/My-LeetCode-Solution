class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        Map<Character, int[]> startEndMap = new HashMap<Character, int[]>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int[] startEnd = startEndMap.getOrDefault(c, new int[]{-1, -1});
            if (startEnd[0] < 0)
                startEnd[0] = i;
            startEnd[1] = i;
            startEndMap.put(c, startEnd);
        }
        int[] endIndices = new int[length];
        Arrays.fill(endIndices, -1);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int[] startEnd = startEndMap.get(c);
            if (startEnd[0] != i)
                continue;
            boolean flag = true;
            int curEnd = startEnd[1];
            for (int j = i + 1; j < length; j++) {
                if (j > curEnd)
                    break;
                char nextC = s.charAt(j);
                int[] nextStartEnd = startEndMap.get(nextC);
                if (nextStartEnd[0] < i) {
                    flag = false;
                    break;
                }
                curEnd = Math.max(curEnd, nextStartEnd[1]);
            }
            if (flag)
                endIndices[i] = curEnd;
        }
        List<String> list = new ArrayList<String>();
        int curStart = -1, curEnd = -1;
        for (int i = 0; i < length; i++) {
            if (i == curEnd) {
                list.add(s.substring(curStart, curEnd + 1));
                continue;
            }
            int end = endIndices[i];
            if (end < 0)
                continue;
            if (curEnd < i) {
                curStart = i;
                curEnd = end;
            } else if (i > curStart && end < curEnd) {
                curStart = i;
                curEnd = end;
            }
            if (i == curEnd)
                list.add(s.substring(curStart, curEnd + 1));
        }
        return list;
    }
}