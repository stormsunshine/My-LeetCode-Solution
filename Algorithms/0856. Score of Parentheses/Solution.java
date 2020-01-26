class Solution {
    public int scoreOfParentheses(String S) {
        if (S == null || S.length() == 0)
            return 0;
        Stack<Character> parenthesesStack = new Stack<Character>();
        Stack<Integer> scoreStack = new Stack<Integer>();
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == '(') {
                parenthesesStack.push(c);
                scoreStack.push(0);
            } else {
                parenthesesStack.pop();
                int prevScore = scoreStack.pop();
                if (prevScore == 0)
                    scoreStack.push(1);
                else {
                    while (scoreStack.peek() != 0)
                        prevScore += scoreStack.pop();
                    scoreStack.pop();
                    scoreStack.push(prevScore * 2);
                }
            }
        }
        int totalScore = 0;
        while (!scoreStack.isEmpty())
            totalScore += scoreStack.pop();
        return totalScore;
    }
}