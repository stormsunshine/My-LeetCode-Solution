class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return word1.length() - word2.length();
            }
        });
        List<String> list = new ArrayList<String>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            String word1 = words[i];
            boolean flag = false;
            for (int j = i + 1; j < length; j++) {
                String word2 = words[j];
                if (word2.indexOf(word1) >= 0) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                list.add(word1);
        }
        return list;
    }
}