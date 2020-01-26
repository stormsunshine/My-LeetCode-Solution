class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();
        if (!wordList.contains(endWord))
            return 0;
        Set<String> visitedSet = new HashSet<String>();
        visitedSet.add(beginWord);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                for (String word : wordList) {
                    if (!visitedSet.contains(word) && differByOne(str, word)) {
                        if (word.equals(endWord))
                            return count;
                        else {
                            visitedSet.add(word);
                            queue.offer(word);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public boolean differByOne(String str1, String str2) {
        if (str1.equals(str2))
            return false;
        if (str1.length() != str2.length())
            return false;
        int length = str1.length();
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            char c1 = str1.charAt(i), c2 = str2.charAt(i);
            if (c1 != c2) {
                if (!flag)
                    flag = true;
                else
                    return false;
            }
        }
        return flag;
    }
}