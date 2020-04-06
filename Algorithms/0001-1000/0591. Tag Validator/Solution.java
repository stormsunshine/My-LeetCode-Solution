public class Solution {
    public boolean isValid(String code) {
        if (code == null || code.length() == 0)
            return false;
        Stack<String> stack = new Stack<String>();
        int length = code.length();
        int index = 0;
        while (index < length) {
            if (index > 0 && stack.isEmpty())
                return false;
            if (index + 9 <= length && code.substring(index, index + 9).equals("<![CDATA[")) {
                index += 9;
                while (index <= length - 3 && !code.substring(index, index + 3).equals("]]>"))
                    index++;
                if (index > length - 3)
                    return false;
                else
                    index += 2;
            } else if (code.substring(index, index + 2).equals("</")) {
                index += 2;
                int start = index;
                while (index < length && code.charAt(index) != '>')
                    index++;
                if (index >= length)
                    return false;
                String tag = code.substring(start, index);
                if (stack.isEmpty() || !stack.peek().equals(tag))
                    return false;
                stack.pop();
            } else if (code.charAt(index) == '<') {
                index++;
                int start = index;
                while (index < length && code.charAt(index) != '>')
                    index++;
                if (index >= length || index == start || index - start > 9)
                    return false;
                for (int i = start; i < index; i++) {
                    char c = code.charAt(i);
                    if (c < 'A' || c > 'Z')
                        return false;
                }
                String tag = code.substring(start, index);
                stack.push(tag);
            }
            index++;
        }
        return stack.isEmpty();
    }
}