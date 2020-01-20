class Solution {
    public int calPoints(String[] ops) {
        int length = ops.length;
        Stack<Integer> stack = new Stack<Integer>();
        int score = 0;
        for (int i = 0; i < length; i++) {
            String str = ops[i];
            if (str.equals("+")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int sum = num1 + num2;
                stack.push(num1);
                stack.push(num2);
                stack.push(sum);
                score += sum;
            } else if (str.equals("D")) {
                int lastScore = stack.peek();
                int newScore = lastScore * 2;
                stack.push(newScore);
                score += newScore;
            } else if (str.equals("C")) {
                int prevScore = stack.pop();
                score -= prevScore;
            } else {
                int points = Integer.parseInt(str);
                stack.push(points);
                score += points;
            }
        }
        return score;
    }
}