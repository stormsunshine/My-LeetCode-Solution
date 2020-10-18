class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        String smallest = s;
        Set<String> visited = new HashSet<String>();
        visited.add(s);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(smallest) < 0)
                smallest = curr;
            String next1 = addToAllOddIndices(curr, a);
            if (visited.add(next1))
                queue.offer(next1);
            String next2 = rotate(curr, b);
            if (visited.add(next2))
                queue.offer(next2);
        }
        
        return smallest;
    }

    public String addToAllOddIndices(String s, int num) {
        char[] array = s.toCharArray();
        int length = array.length;
        for (int i = 1; i < length; i += 2) {
            int digit = array[i] - '0';
            digit = (digit + num) % 10;
            array[i] = (char) (digit + '0');
        }
        return new String(array);
    }

    public String rotate(String s, int positions) {
        int length = s.length();
        positions %= length;
        StringBuffer sb = new StringBuffer();
        sb.append(s.substring(length - positions));
        sb.append(s.substring(0, length - positions));
        return sb.toString();
    }
}