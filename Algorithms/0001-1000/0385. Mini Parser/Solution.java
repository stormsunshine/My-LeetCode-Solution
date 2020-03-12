/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0)
            return new NestedInteger();
        if (s.indexOf('[') < 0) {
            int num = Integer.parseInt(s);
            return new NestedInteger(num);
        }
        s = s.replaceAll("\\[", " [ ");
        s = s.replaceAll("]", " ] ");
        s = s.replaceAll(",", " ");
        s = s.trim();
        while (s.indexOf("  ") >= 0)
            s = s.replaceAll("  ", " ");
        String[] array = s.split(" ");
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            String str = array[i];
            if (str.equals("["))
                stack.push(new NestedInteger());
            else if (str.equals("]")) {
                if (stack.size() > 1) {
                    NestedInteger list = stack.pop();
                    stack.peek().add(list);
                }
            } else {
                int num = Integer.parseInt(str);
                stack.peek().add(new NestedInteger(num));
            }
        }
        return stack.pop();
    }
}