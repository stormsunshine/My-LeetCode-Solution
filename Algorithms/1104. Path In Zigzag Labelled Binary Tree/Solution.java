class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        Stack<Integer> stack = new Stack<Integer>();
        while (label >= 1) {
            stack.push(label);
            int log = (int) (Math.log(label) / Math.log(2));
            int minValue = (int) Math.pow(2, log);
            label = minValue * 3 - 1 - label;
            label /= 2;
        }
        List<Integer> path = new ArrayList<Integer>();
        while (!stack.isEmpty())
            path.add(stack.pop());
        return path;
    }
}