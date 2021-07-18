class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<Character>();
        int brokenCount = brokenLetters.length();
        for (int i = 0; i < brokenCount; i++)
            set.add(brokenLetters.charAt(i));
        int canType = 0;
        String[] array = text.split(" ");
        for (String word : array) {
            boolean flag = true;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                if (set.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                canType++;
        }
        return canType;
    }
}