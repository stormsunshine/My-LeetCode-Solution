class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> resultList = new ArrayList<Integer>();
        int low = 1, high = input.length() - 1;
        for (int i = low; i < high; i++) {
            char c = input.charAt(i);
            if (isOperator(c)) {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> leftResultList = diffWaysToCompute(left);
                List<Integer> rightResultList = diffWaysToCompute(right);
                for (int num1 : leftResultList) {
                    for (int num2 : rightResultList) {
                        switch (c) {
                            case '+':
                                resultList.add(num1 + num2);
                                break;
                            case '-':
                                resultList.add(num1 - num2);
                                break;
                            case '*':
                                resultList.add(num1 * num2);
                                break;
                            default:
                        }
                    }
                }
            }
        }
        if (resultList.size() == 0)
            resultList.add(Integer.parseInt(input));
        return resultList;
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}