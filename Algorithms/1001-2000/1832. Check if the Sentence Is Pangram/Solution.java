class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<Character>();
        int length = sentence.length();
        for (int i = 0; i < length; i++) {
            char c = sentence.charAt(i);
            if (c >= 'a' && c <= 'z')
                set.add(c);
        }
        return set.size() == 26;
    }
}