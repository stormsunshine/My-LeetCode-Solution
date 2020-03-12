class Solution {
    public int distinctEchoSubstrings(String text) {
        Set<String> substringsSet = new HashSet<String>();
        int length = text.length();
        for (int i = 0; i < length; i++) {
            int maxLength = length - i;
            for (int j = 2; j <= maxLength; j += 2) {
                String substr1 = text.substring(i, i + j / 2), substr2 = text.substring(i + j / 2, i + j);
                if (substr1.equals(substr2))
                    substringsSet.add(substr1 + substr2);
            }
        }
        return substringsSet.size();
    }
}