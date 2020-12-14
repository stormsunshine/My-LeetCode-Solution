class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<Character>();
        int length = allowed.length();
        for (int i = 0; i < length; i++)
            set.add(allowed.charAt(i));
        int count = 0;
        for (String word : words) {
            boolean flag = true;
            int wordLength = word.length();
            for (int i = 0; i < wordLength; i++) {
                if (!set.contains(word.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }
        return count;
    }
}