class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
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