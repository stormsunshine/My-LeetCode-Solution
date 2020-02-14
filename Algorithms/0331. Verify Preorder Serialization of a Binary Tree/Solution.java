public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0)
            return false;
        String[] array = preorder.split(",");
        Stack<String> stack = new Stack<String>();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            String str = array[i];
            if ("#".equals(str)) {
                while (!stack.isEmpty() && "#".equals(stack.peek())) {
                    if (stack.size() < 2)
                        return false;
                    for (int j = 0; j < 2; j++)
                        stack.pop();
                }
            }
            stack.push(str);
        }
        if (stack.isEmpty() || !"#".equals(stack.pop()))
            return false;
        return stack.isEmpty();
    }
}