class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuffer sb = new StringBuffer();
        List<Integer> duplicatesCounts = new ArrayList<Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int curLength = sb.length();
            char c = s.charAt(i);
            int curCount = 1;
            if (curLength > 0 && c == sb.charAt(curLength - 1))
                curCount = duplicatesCounts.get(curLength - 1) + 1;
            if (curCount == k) {
                int startIndex = curLength - k + 1;
                sb.delete(startIndex, curLength);
                for (int j = curLength - 1; j >= startIndex; j--)
                    duplicatesCounts.remove(j);
            } else {
                sb.append(c);
                duplicatesCounts.add(curCount);
            }
        }
        return sb.toString();
    }
}