class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1)
            return s;
        List<List<Character>> lists = new ArrayList<List<Character>>();
        for (int i = 0; i < numRows; i++)
            lists.add(new ArrayList<Character>());
        int groupSize = (numRows - 1) * 2;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int remainder = i % groupSize;
            int group = Math.min(remainder, groupSize - remainder);
            lists.get(group).add(c);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            List<Character> list = lists.get(i);
            int size = list.size();
            for (int j = 0; j < size; j++) {
                char c = list.get(j);
                sb.append(c);
            }
        }
        String converted = sb.toString();
        return converted;
    }
}