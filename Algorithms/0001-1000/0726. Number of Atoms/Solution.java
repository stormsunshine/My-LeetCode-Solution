class Solution {
    public String countOfAtoms(String formula) {
        StringBuffer sb = new StringBuffer();
        sb.append(formula.charAt(0));
        char prevC = formula.charAt(0);
        int length = formula.length();
        for (int i = 1; i < length; i++) {
            char c = formula.charAt(i);
            boolean flag = Character.isLowerCase(c) || Character.isDigit(c) && Character.isDigit(prevC);
            if (!flag)
                sb.append(' ');
            sb.append(c);
            prevC = c;
        }
        String[] array = sb.toString().split(" ");
        Stack<String> stack = new Stack<String>();
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            String str = array[i];
            if (str.equals(")")) {
                if (i < arrayLength - 1 && Character.isDigit(array[i + 1].charAt(0)))
                    stack.push(str);
                else {
                    Stack<String> tempStack = new Stack<String>();
                    while (!stack.peek().equals("("))
                        tempStack.push(stack.pop());
                    stack.pop();
                    while (!tempStack.isEmpty())
                        stack.push(tempStack.pop());
                }
            } else if (Character.isDigit(str.charAt(0))) {
                int count = Integer.parseInt(str);
                String prev = stack.pop();
                if (prev.equals(")")) {
                    Stack<String> tempStack = new Stack<String>();
                    while (!stack.peek().equals("(")) {
                        String element = stack.pop();
                        int index = element.indexOf(',');
                        if (index >= 0) {
                            String atom = element.substring(0, index);
                            int atomCount = Integer.parseInt(element.substring(index + 1)) * count;
                            tempStack.push(atom + "," + atomCount);
                        } else
                            tempStack.push(element + "," + str);
                    }
                    stack.pop();
                    while (!tempStack.isEmpty())
                        stack.push(tempStack.pop());
                } else {
                    String curStr = prev + "," + str;
                    stack.push(curStr);
                }
            } else
                stack.push(str);
        }
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        while (!stack.isEmpty()) {
            String atomCount = stack.pop();
            int index = atomCount.indexOf(',');
            if (index >= 0) {
                String atom = atomCount.substring(0, index);
                int count = Integer.parseInt(atomCount.substring(index + 1));
                count += map.getOrDefault(atom, 0);
                map.put(atom, count);
            } else {
                int count = map.getOrDefault(atomCount, 0) + 1;
                map.put(atomCount, count);
            }
        }
        StringBuffer output = new StringBuffer();
        Set<String> keySet = map.keySet();
        for (String atom : keySet) {
            int count = map.get(atom);
            output.append(atom);
            if (count > 1)
                output.append(count);
        }
        return output.toString();
    }
}