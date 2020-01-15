class Solution {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        if (k >= length)
            return "0";
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        while (index < length) {
            if (k == 0)
                break;
            int val = num.charAt(index) - '0';
            while (!stack.isEmpty() && val < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            if (!stack.isEmpty() || val != 0)
                stack.push(val);
            index++;
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty())
            sb.insert(0, String.valueOf(stack.pop()));
        if (index < length)
            sb.append(num.substring(index));
        return sb.length() == 0 ? "0" : sb.toString();
    }
}