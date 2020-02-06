class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] endArray = new int[26];
        Arrays.fill(endArray, -1);
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            int letterIndex = c - 'a';
            endArray[letterIndex] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            int letterIndex = c - 'a';
            int curEnd = endArray[letterIndex];
            end = Math.max(end, curEnd);
            if (i == end) {
                partition.add(end - start + 1);
                start = i + 1;
            }
        }
        return partition;
    }
}