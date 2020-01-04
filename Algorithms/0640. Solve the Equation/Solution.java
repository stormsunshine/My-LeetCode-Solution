class Solution {
    public String solveEquation(String equation) {
        equation = equation.replaceAll("-", "+-");
        if (equation.charAt(0) == '+')
            equation = equation.substring(1);
        equation = equation.replace("=+", "=");
        int equalIndex = equation.indexOf('=');
        String leftSide = equation.substring(0, equalIndex);
        String rightSide = equation.substring(equalIndex + 1);
        String[] leftArray = leftSide.split("\\+");
        String[] rightArray = rightSide.split("\\+");
        int xTerm = 0, constantTerm = 0;
        for (String leftTerm : leftArray) {
            if (leftTerm.contains("x")) {
                if (leftTerm.equals("x"))
                    xTerm++;
                else if (leftTerm.equals("-x"))
                    xTerm--;
                else {
                    String coefficientStr = leftTerm.substring(0, leftTerm.indexOf('x'));
                    int coefficient = Integer.parseInt(coefficientStr);
                    xTerm += coefficient;
                }
            } else
                constantTerm -= Integer.parseInt(leftTerm);
        }
        for (String rightTerm : rightArray) {
            if (rightTerm.contains("x")) {
                if (rightTerm.equals("x"))
                    xTerm--;
                else if (rightTerm.equals("-x"))
                    xTerm++;
                else {
                    String coefficientStr = rightTerm.substring(0, rightTerm.indexOf('x'));
                    int coefficient = Integer.parseInt(coefficientStr);
                    xTerm -= coefficient;
                }
            } else
                constantTerm += Integer.parseInt(rightTerm);
        }
        if (xTerm != 0) {
            int solution = constantTerm / xTerm;
            return "x=" + solution;
        } else if (constantTerm == 0)
            return "Infinite solutions";
        else
            return "No solution";
    }
}