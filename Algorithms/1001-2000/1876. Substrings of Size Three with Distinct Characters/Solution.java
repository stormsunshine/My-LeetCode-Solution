class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        int length = s.length();
        for (int i = 3; i <= length; i++) {
            String sub = s.substring(i - 3, i);
            Set<Character> set = new HashSet<Character>();
            for (int j = 0; j < 3; j++)
                set.add(sub.charAt(j));
            if (set.size() == 3)
                count++;
        }
        return count;
    }
}