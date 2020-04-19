class Solution {
    public String reformat(String s) {
        Queue<Character> letterQueue = new LinkedList<Character>();
        Queue<Character> digitQueue = new LinkedList<Character>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c))
                letterQueue.offer(c);
            else
                digitQueue.offer(c);
        }
        int letterCounts = letterQueue.size(), digitCounts = digitQueue.size();
        if (Math.abs(letterCounts - digitCounts) > 1)
            return "";
        else if (digitCounts > letterCounts) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < letterCounts; i++) {
                sb.append(digitQueue.poll());
                sb.append(letterQueue.poll());
            }
            sb.append(digitQueue.poll());
            return sb.toString();
        } else {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digitCounts; i++) {
                sb.append(letterQueue.poll());
                sb.append(digitQueue.poll());
            }
            if (letterCounts > digitCounts)
                sb.append(letterQueue.poll());
            return sb.toString();
        }
    }
}