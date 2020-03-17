class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        int wordsCount = words.length;
        for (int i = 1; i < wordsCount; i++) {
            String prevWord = words[i - 1], currWord = words[i];
            int length = Math.min(prevWord.length(), currWord.length());
            for (int j = 0; j < length; j++) {
                char prevC = prevWord.charAt(j), currC = currWord.charAt(j);
                if (j == length - 1 && prevC == currC && prevWord.length() > currWord.length())
                    return "";
                else if (prevC != currC) {
                    Set<Character> set = map.getOrDefault(prevC, new HashSet<Character>());
                    set.add(currC);
                    map.put(prevC, set);
                    break;
                }
            }
        }
        int[] indegrees = new int[26];
        Arrays.fill(indegrees, -1);
        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                indegrees[c - 'a'] = 0;
            }
        }
        Set<Character> keySet = map.keySet();
        for (char key : keySet) {
            Set<Character> set = map.get(key);
            for (char next : set)
                indegrees[next - 'a']++;
        }
        int lettersCount = 0;
        StringBuffer order = new StringBuffer();
        Queue<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < 26; i++) {
            if (indegrees[i] >= 0) {
                lettersCount++;
                if (indegrees[i] == 0)
                    queue.offer((char) ('a' + i));
            }
        }
        while (!queue.isEmpty()) {
            char letter = queue.poll();
            order.append(letter);
            Set<Character> set = map.getOrDefault(letter, new HashSet<Character>());
            for (char nextLetter : set) {
                indegrees[nextLetter - 'a']--;
                if (indegrees[nextLetter - 'a'] == 0)
                    queue.offer(nextLetter);
            }
        }
        return order.length() == lettersCount ? order.toString() : "";
    }
}