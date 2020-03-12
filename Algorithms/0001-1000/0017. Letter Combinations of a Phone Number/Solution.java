class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> letterCombinations = new ArrayList<String>();
        Queue<String> queue = new LinkedList<String>();
        int length = digits.length();
        for (int i = 0; i < length; i++) {
            Queue<String> tempQueue = new LinkedList<String>();
            while (!queue.isEmpty())
                tempQueue.offer(queue.poll());
            int digit = digits.charAt(i) - '0';
            String letters = map.getOrDefault(digit, "");
            char[] array = letters.toCharArray();
            if (tempQueue.isEmpty()) {
                for (char c : array)
                    queue.offer(String.valueOf(c));
            } else {
                while (!tempQueue.isEmpty()) {
                    String prev = tempQueue.poll();
                    for (char c : array)
                        queue.offer(prev + c);
                }
            }
        }
        while (!queue.isEmpty())
            letterCombinations.add(queue.poll());
        return letterCombinations;
    }
}