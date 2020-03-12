class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        int length = asteroids.length;
        for (int i = length - 1; i >= 0; i--) {
            int asteroid = asteroids[i];
            if (asteroid < 0)
                stack.push(asteroid);
            else {
                boolean flag = true;
                while (!stack.isEmpty() && stack.peek() < 0) {
                    int prev = stack.peek();
                    if (asteroid < -prev) {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                        if (asteroid == -prev) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag)
                    stack.push(asteroid);
            }
        }
        int size = stack.size();
        int[] remain = new int[size];
        for (int i = 0; i < size; i++)
            remain[i] = stack.pop();
        return remain;
    }
}