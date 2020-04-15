class Solution {
    public int evaluate(String expression) {
        StringBuffer sb = new StringBuffer(expression);
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == ')')
                sb.insert(i, ' ');
        }
        String[] array = sb.toString().split(" ");
        Stack<List<String>> expressionStack = new Stack<List<String>>();
        expressionStack.push(new ArrayList<String>());
        Stack<Map<String, String>> variableValuesStack = new Stack<Map<String, String>>();
        variableValuesStack.push(new HashMap<String, String>());
        int length = array.length;
        for (int i = 0; i < length; i++) {
            String str = array[i];
            if (str.charAt(0) == '(') {
                List<String> list = new ArrayList<String>();
                list.add(str.substring(1));
                expressionStack.push(list);
                if (list.get(0).equals("let")) {
                    Map<String, String> prevMap = variableValuesStack.peek();
                    Set<String> keySet = prevMap.keySet();
                    Map<String, String> map = new HashMap<String, String>();
                    for (String key : keySet)
                        map.put(key, prevMap.get(key));
                    variableValuesStack.push(map);
                }
            } else if (str.equals(")")) {
                List<String> lastExpression = expressionStack.pop();
                List<String> secondLastExpression = expressionStack.pop();
                String lastExpressionType = lastExpression.get(0);
                if (lastExpressionType.equals("let")) {
                    String lastStr = lastExpression.get(lastExpression.size() - 1);
                    if (Character.isLetter(lastStr.charAt(0))) {
                        Map<String, String> lastMap = variableValuesStack.peek();
                        secondLastExpression.add(lastMap.get(lastStr));
                    } else
                        secondLastExpression.add(lastStr);
                    variableValuesStack.pop();
                } else if (lastExpressionType.equals("add")) {
                    int curResult = Integer.parseInt(lastExpression.get(1)) + Integer.parseInt(lastExpression.get(2));
                    secondLastExpression.add(String.valueOf(curResult));
                } else if (lastExpressionType.equals("mult")) {
                    int curResult = Integer.parseInt(lastExpression.get(1)) * Integer.parseInt(lastExpression.get(2));
                    secondLastExpression.add(String.valueOf(curResult));
                }
                if (secondLastExpression.get(0).equals("let")) {
                    Map<String, String> lastMap = variableValuesStack.pop();
                    int size = secondLastExpression.size();
                    lastMap.put(secondLastExpression.get(size - 2), secondLastExpression.get(size - 1));
                    variableValuesStack.push(lastMap);
                }
                expressionStack.push(secondLastExpression);
            } else if (Character.isLetter(str.charAt(0))) {
                List<String> lastExpression = expressionStack.pop();
                Map<String, String> lastMap = variableValuesStack.pop();
                if (lastExpression.get(0).equals("let")) {
                    if (lastExpression.size() % 2 == 1)
                        lastExpression.add(str);
                    else {
                        String value = lastMap.get(str);
                        lastMap.put(lastExpression.get(lastExpression.size() - 1), value);
                        lastExpression.add(value);
                    }
                } else
                    lastExpression.add(lastMap.get(str));
                expressionStack.push(lastExpression);
                variableValuesStack.push(lastMap);
            } else {
                List<String> lastExpression = expressionStack.pop();
                if (lastExpression.get(0).equals("let")) {
                    Map<String, String> lastMap = variableValuesStack.pop();
                    lastMap.put(lastExpression.get(lastExpression.size() - 1), str);
                    variableValuesStack.push(lastMap);
                }
                lastExpression.add(str);
                expressionStack.push(lastExpression);
            }
        }
        int result = Integer.parseInt(expressionStack.pop().get(0));
        return result;
    }
}