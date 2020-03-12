class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> sentences = new ArrayList<String>();
        if (!existWordBreak(s, wordDict))
            return sentences;
        Set<String> wordSet = new HashSet<String>();
        int maxWordLength = 0;
        for (String word : wordDict) {
            wordSet.add(word);
            maxWordLength = Math.max(maxWordLength, word.length());
        }
        int length = s.length();
        boolean[] visited = new boolean[length];
        Queue<Integer> indicesQueue = new LinkedList<Integer>();
        Queue<String> sentencesQueue = new LinkedList<String>();
        indicesQueue.offer(0);
        sentencesQueue.offer("");
        while (!indicesQueue.isEmpty()) {
            int start = indicesQueue.poll();
            String sentence = sentencesQueue.poll();
            int maxEnd = Math.min(start + maxWordLength, length);
            for (int end = start + 1; end <= maxEnd; end++) {
                StringBuffer newSentenceSB = new StringBuffer(sentence);
                String substr = s.substring(start, end);
                if (wordSet.contains(substr)) {
                    if (start > 0)
                        newSentenceSB.append(" ");
                    newSentenceSB.append(substr);
                    if (end == length)
                        sentences.add(newSentenceSB.toString());
                    else {
                        indicesQueue.offer(end);
                        sentencesQueue.offer(newSentenceSB.toString());
                    }
                }
            }
            visited[start] = true;
        }
        return sentences;
    }

    public boolean existWordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<String>();
        for (String word : wordDict)
            wordSet.add(word);
        int length = s.length();
        boolean[] visited = new boolean[length];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (!visited[start]) {
                for (int end = start + 1; end <= length; end++) {
                    String substr = s.substring(start, end);
                    if (wordSet.contains(substr)) {
                        if (end == length)
                            return true;
                        else
                            queue.offer(end);
                    }
                }
                visited[start] = true;
            }
        }
        return false;
    }
}